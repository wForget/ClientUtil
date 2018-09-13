package cn.wangz.clientutil.druid;

import in.zapr.druid.druidry.client.DruidClient;
import in.zapr.druid.druidry.client.DruidConfiguration;
import in.zapr.druid.druidry.client.DruidJerseyClient;
import in.zapr.druid.druidry.query.DruidQuery;

import java.util.List;


/**
 * Created by hadoop on 2018/9/3.
 */
public class DruidClientUtil {

    private static DruidConfiguration config = null;
    private static DruidClient client = null;

    static {
        init();
    }

    public static void init() {
        config =  DruidConfiguration
                .builder()
                .host(DruidConf.host)
                .port(DruidConf.port)
                .endpoint(DruidConf.endpoint)
                .build();

        client = new DruidJerseyClient(config);
        try {
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (client != null) {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String query(DruidQuery query) {
        try {
            return client.query(query);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> query(DruidQuery query, Class<T> ResponseClass) {
        try {
            List<T> response = client.query(query, ResponseClass);
            return response;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
