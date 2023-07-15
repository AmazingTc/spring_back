package com.menglin.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateUtil {
    public static String getDateTime(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年M月d日 H小时m分钟s秒");
        String dateTime = dtf.format(ldt);
        return dateTime;
    }
}
