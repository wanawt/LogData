package com.lanren.hhsqlog.hhsqlog.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import generate.LogData;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.*;
import java.util.ArrayList;

public class ProcessLogFiles {
    // 读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LogData parseJsonObj(String string) {
        LogData logData = null;
        String newS = StringEscapeUtils.unescapeJava(string);
        if (newS.startsWith("\"")) {
            newS = newS.substring(1, newS.length() - 1);
        }
        if (newS.startsWith("{") && newS.endsWith("}") && JsonUtil.isJSONValid2(newS)) {
            JSONObject jobj = JSON.parseObject(newS);
            logData = (LogData) JSONObject.toJavaObject(jobj, LogData.class);
            System.out.println(newS);

            // 解析item项
            String item = logData.getItem();
            if (item != null && item.startsWith("{") && item.endsWith("}") && JsonUtil.isJSONValid2(item)) {
                JSONObject tempJobj = JSON.parseObject(item);
                LogData tmpData = (LogData) JSONObject.toJavaObject(tempJobj, LogData.class);
                if (tmpData.getItem_id() != null && logData.getItem_id() == null) {
                    logData.setItem_id(tmpData.getItem_id());
                }
                if (tmpData.getShop_type() != null && logData.getShop_type() == null) {
                    logData.setShop_type(tmpData.getShop_type());
                }
                if (tmpData.getTitle() != null && logData.getTitle() == null) {
                    logData.setTitle(tmpData.getTitle());
                }
            }
        }
        return logData;
    }

    // 解析日志文件 成 数组
    public static ArrayList parseJsonFile() {
        String s;
        ArrayList jsonObjs = new ArrayList();
        int count = 0;
        String dPath = ProcessLogFiles.class.getClassLoader().getResource("./logfiles/hhsq_data/").getPath();

        File file = new File(dPath);
        File[] fs = file.listFiles();
        for(File f:fs) {
            if(!f.isDirectory()) {
                System.out.println(f.getPath());
                s = readJsonFile(f.getPath());
                String[] jsonStrings = s.split("\n");
                for (int i = 0; i < jsonStrings.length; i++) {
                    LogData logData = parseJsonObj(jsonStrings[i]);
                    if (logData.getOs() != null) {
                        jsonObjs.add(logData);
                        count++;
                        System.out.println('\n'+count);
                    }
                }
            } else {
                File[] subFs = f.listFiles();
                for (File subF:subFs) {
                    s = readJsonFile(subF.getPath());
                    String[] jsonStrings = s.split("\n");
                    for (int i = 0; i < jsonStrings.length; i++) {
                        LogData logData = parseJsonObj(jsonStrings[i]);
                        if (logData.getOs() != null) {
                            jsonObjs.add(logData);
                            count++;
                            System.out.println('\n'+count);
                        }
                    }
                }
            }
        }
        return jsonObjs;
    }
}
