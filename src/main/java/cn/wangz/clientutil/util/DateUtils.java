package cn.wangz.clientutil.util;

import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    public static Date toZeroDate(Date date) {
        long time = date.getTime();
        long zero = time - (time + TimeZone.getDefault().getRawOffset())%(1000*3600*24);
        return new Date(zero);
    }

}
