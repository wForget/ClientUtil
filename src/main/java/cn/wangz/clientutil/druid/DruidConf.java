package cn.wangz.clientutil.druid;

import cn.wangz.clientutil.conf.BaseConf;
import lombok.Value;

/**
 * Created by hadoop on 2018/9/3.
 */
public class DruidConf extends BaseConf {

    public static String host = conf.getString("druid.host");

    public static Integer port = conf.getInt("druid.port");

    public static String endpoint = conf.getString("druid.endpoint");

    public static String dataSource = conf.getString("druid.dataSource");
}
