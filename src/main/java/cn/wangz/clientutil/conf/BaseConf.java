package cn.wangz.clientutil.conf;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created by hadoop on 2018/3/13.
 */
public class BaseConf {
    public static Config conf = null;

    static {
        conf = ConfigFactory.load("application.conf");
    }
}
