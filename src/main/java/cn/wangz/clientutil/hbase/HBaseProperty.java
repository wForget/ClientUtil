package cn.wangz.clientutil.hbase;

import cn.wangz.clientutil.conf.BaseConf;

/**
 * Created by hadoop on 2018/1/23.
 */
public class HBaseProperty extends BaseConf {

    public static int zkClinePort = conf.getInt("hbase.zookeeper.property.clientPort");

    public static String zkQuorum = conf.getString("hbase.zookeeper.quorum");

    public static String tbaleName = conf.getString("hbase.table.name");

    public static String family = conf.getString("hbase.table.family");
}
