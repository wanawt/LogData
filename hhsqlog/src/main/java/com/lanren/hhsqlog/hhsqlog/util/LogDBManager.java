package com.lanren.hhsqlog.hhsqlog.util;

import generate.LogData;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class LogDBManager {

    private static Connection mConnect;
    private static Statement stmt;

    public static void prepareSql () throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        mConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hhsqlog?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true","root","Zwfwz@52525");
        stmt = mConnect.createStatement();
    }

    public static ArrayList queryLogData() throws SQLException, ClassNotFoundException {
        prepareSql();;
        String sql = "select count(keyword) as 'count', keyword from log_data\n" +
                "group by keyword having count(*)>1\n" +
                "order by count(keyword) desc;";

        ResultSet rs = stmt.executeQuery(sql);
        int i=0;
        ArrayList list = new ArrayList();
        while (rs.next()) {
            if (i >= 5) break;
            Map<String, String> map = new HashMap<String, String>();
            map.put("count", String.valueOf(rs.getInt("count")));
            map.put("keyword", rs.getString("keyword"));
            list.add(map);
            i++;
        }
        // 完成后关闭
        rs.close();
        stmt.close();
        mConnect.close();
        return list;
    }

    public static void insertTableFromLog (ArrayList<LogData> jsonObjs) throws SQLException, ClassNotFoundException {
        prepareSql();
        int arraySize = jsonObjs.size();
        for (int i = 0; i < arraySize; i++) {
            LogData logData = (LogData)jsonObjs.get(i);
            if (logData != null) {
                String insertSql = "INSERT INTO log_data (os, channel, create_time, device_id, device_unique_id," +
                        " environment, ip, topic, platform, module, user_id, vendor, version, item, `from`, keyword, " +
                        "click_position, spot_id, page, item_id, shop_type, title, log_time) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = mConnect.prepareStatement(insertSql);
                ps.setString(1, logData.getOs());
                ps.setString(2, logData.getChannel());
                ps.setString(3, logData.getCreateTime());
                ps.setString(4, logData.getDeviceId());
                ps.setString(5, logData.getDeviceUniqueId());
                ps.setString(6, logData.getEnvironment());
                ps.setString(7, logData.getIp());
                ps.setString(8, logData.getTopic());
                ps.setString(9, logData.getPlatform());
                ps.setString(10, logData.getModule());
                ps.setString(11, logData.getUserId());
                ps.setString(12, logData.getVendor());
                ps.setString(13, logData.getVersion());
                ps.setString(14, logData.getItem());
                ps.setString(15, logData.getFrom());
                ps.setString(16, logData.getKeyword());
                ps.setString(17, logData.getSpot_id());
                ps.setString(18, logData.getClick_position());
                ps.setString(19, logData.getPage());
                ps.setString(20, logData.getItem_id());
                ps.setString(21, logData.getShop_type());
                ps.setString(22, logData.getTitle());

                // 日期时间
                String createTime = logData.getCreateTime();
                if (createTime != null && createTime.startsWith("20")) {
                    Timestamp dateTime = Timestamp.valueOf(createTime);
                    if (dateTime != null) {
                        ps.setTimestamp(23, dateTime);
                    } else {
                        ps.setTimestamp(23, new Timestamp(new java.util.Date().getTime()));
                    }
                } else {
                    ps.setTimestamp(23, new Timestamp(new Date().getTime()));
                }
                int result = ps.executeUpdate();
                // 展开结果集数据库
                if (result > 0) {
                    System.out.print(arraySize + "---" + i + "-插入成功！\n");
                } else {
                    System.out.print("插入失败！");
                }
            }
        }
        stmt.close();
        mConnect.close();
    }
}
