package cn.wangz.clientutil.hive;

import java.sql.*;

/**
 * Created by hadoop on 2018/9/13.
 */
public class HiveServer {

	private Connection connection = null;
	private PreparedStatement ps = null;

	public HiveServer() {
		init();
	}

	// 创建连接
	public void init() {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			connection = DriverManager.getConnection(HiveConf.url,"hive", "hive");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 获取链接
	public Connection getConnection() {
		return this.connection;
	}

	// 查询
	public ResultSet exec(String hql) throws SQLException {
		ps = connection.prepareStatement(hql);
		return ps.executeQuery();
	}

	// 关闭连接
	public void close() {
		try {
			if (ps != null) {
				ps.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
