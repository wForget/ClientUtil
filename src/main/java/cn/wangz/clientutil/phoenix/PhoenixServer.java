package cn.wangz.clientutil.phoenix;

import java.sql.*;

/**
 * Created by hadoop on 2019/1/14.
 */
public class PhoenixServer {
    private Connection connection = null;
    private PreparedStatement ps = null;

    public PhoenixServer() {
        init();
    }

    // 创建连接
    public void init() {
        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            connection = DriverManager.getConnection("jdbc:phoenix:dmp-test01,dmp-test02,dmp-test03:2181");
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

    public static void main(String[] args) throws Exception {
//        String sql = "select * from PUBG_COMPETITION limit 1";
//        PhoenixServer phoenixServer = new PhoenixServer();
//        ResultSet resultSet = phoenixServer.exec(sql);
//        resultSet.next();
//        System.out.println(resultSet.getObject(1));

//        String sql = "UPSERT INTO PUBG.MATCH_INDEX(LOWERNICKNAME, STARTEDAT, MATCHID, MODE, QUEUESIZE, TOTALRANK, TYPE) VALUES ('test', '2018-09-02', 'test', 'tpp', 2 ,90, 'te')";
//        PhoenixServer phoenixServer = new PhoenixServer();
//        Connection connection = phoenixServer.getConnection();
//        connection.prepareStatement(sql).execute();
//        connection.commit();
//        phoenixServer.close();
    }
}
