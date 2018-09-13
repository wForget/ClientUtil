package cn.wangz.clientutil.mongo;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by hadoop on 2018/9/13.
 */
public class MgoServer {
	
	private String	serverAddress 	= null;	// 服务地址
	private int		port 			= 0;	// 端口
	private String	dbName 			= null; // 库名

	private MongoClient mongoClient = null;

	/**
	 * 构造器
	 * @param serverAddress
	 * @param port
	 * @param dbName
	 */
	public MgoServer(String serverAddress, int port, String dbName) {
		this.serverAddress = serverAddress;
		this.port = port;
		this.dbName = dbName;

		this.mongoClient = new MongoClient(this.serverAddress, this.port);
	}
	
	/**
	 * 构造器
	 * @param serverAddress
	 * @param dbName
	 * @throws UnknownHostException
	 */
	public MgoServer(String serverAddress, String dbName) {
		this(serverAddress, 27017, dbName);
	}
	
	/**
	 * 构造器
	 * @param serverAddressList 集群地址
	 * @param dbName 数据库名称
	 * @throws UnknownHostException
	 */
	public MgoServer(List<ServerAddress> serverAddressList, String dbName) {
		this.dbName = dbName;
		this.mongoClient = new MongoClient(serverAddressList);
	}
	
	/**
	 * @return 获取MongoDB链接
	 */
	public MongoCollection<Document> getDBCollection(String collectionName) {
		return getDB().getCollection(collectionName);
	}
	
	public MongoDatabase getDB() {
		return this.mongoClient.getDatabase(this.dbName);
	}
	

	/**
	 *  关闭Mongo数据库链接
	 */
	public void close() {
		if (this.mongoClient != null) {
			mongoClient.close();
		}
	}

}
