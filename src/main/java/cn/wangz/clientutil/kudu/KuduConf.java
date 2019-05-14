package cn.wangz.clientutil.kudu;

import cn.wangz.clientutil.conf.BaseConf;

public class KuduConf extends BaseConf {

    public static String masterAddresses = conf.getString("kudu.masterAddresses");

    public static long timeoutMillis = conf.getLong("kudu.timeoutMillis");

    public static boolean ignoreDuplicateRows = conf.getBoolean("kudu.ignoreDuplicateRows");

    public static int batchSize = conf.getInt("kudu.batchSize");
}
