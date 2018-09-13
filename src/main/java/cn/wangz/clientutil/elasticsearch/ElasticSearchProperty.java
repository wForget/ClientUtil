package cn.wangz.clientutil.elasticsearch;

import cn.wangz.clientutil.conf.BaseConf;

import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/9/4.
 */
public class ElasticSearchProperty extends BaseConf {

    public static int bulkActions = conf.getInt("elasticsearch.bulkactions");

    public static long flushInterval = conf.getLong("elasticsearch.flushinterval");

    public static String index = conf.getString("elasticsearch.index");

    public static String type = conf.getString("elasticsearch.type");

    public static List<Map> transportAddressList = null;
    static {
        String[] transportAddressArr = conf.getString("elasticsearch.transportaddress").split(",");
        List<Map> list = new ArrayList();
        for (int i = 0; i < transportAddressArr.length; i++) {
            String[] arr = transportAddressArr[i].trim().split(":");
            String host = arr[0].trim();
            int port = Integer.valueOf(arr[1].trim());
            Map map = new HashMap();
            map.put("host", host);
            map.put("port", port);
            list.add(map);
        }
        transportAddressList = list;
    }
}
