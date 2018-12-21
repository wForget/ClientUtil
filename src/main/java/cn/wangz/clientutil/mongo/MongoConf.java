package cn.wangz.clientutil.mongo;

import cn.wangz.clientutil.conf.BaseConf;
import com.mongodb.ServerAddress;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hadoop on 2018/9/13.
 */
public class MongoConf extends BaseConf {

	public static String DB = conf.getString("mongo.db");

	public static String COL = conf.getString("mongo.col");

	public static List<ServerAddress> SERVER_ADDRESS = null;
	static {
		String cluster = conf.getString("mongo.cluster");
		List<ServerAddress> serverAddresses = new ArrayList<ServerAddress>();
		String[] serverAddressStrArr = cluster.split(",");
		for (int i = 0; i < serverAddressStrArr.length; i++) {
			String serverAddressStr = serverAddressStrArr[i];
			String host = serverAddressStr.split(":")[0];
			int port = Integer.valueOf(serverAddressStr.split(":")[1]);
			serverAddresses.add(new ServerAddress(host, port));
		}
		SERVER_ADDRESS = serverAddresses;
	}
}
