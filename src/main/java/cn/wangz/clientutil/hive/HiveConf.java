package cn.wangz.clientutil.hive;

import cn.wangz.clientutil.conf.BaseConf;

/**
 * Created by hadoop on 2018/9/13.
 */
public class HiveConf extends BaseConf {
    public static String url = conf.getString("hive.url");
}
