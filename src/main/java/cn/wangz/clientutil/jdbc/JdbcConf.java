package cn.wangz.clientutil.jdbc;

import cn.wangz.clientutil.conf.BaseConf;

/**
 * @author wang_zh
 * @date 2019/11/21
 */
public class JdbcConf extends BaseConf {

    public static String DRIVER = conf.getString("jdbc.driver");
    public static String URL = conf.getString("jdbc.url");
    public static String USER = conf.getString("jdbc.user");
    public static String PASSWORD = conf.getString("jdbc.password");

}
