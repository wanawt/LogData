package com.lanren.hhsqlog.hhsqlog.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static Date convertDateString(String dateString) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = df.parse(dateString);
        return date;
    }
}
