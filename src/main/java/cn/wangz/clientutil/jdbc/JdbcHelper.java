package cn.wangz.clientutil.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @author wang_zh
 * @date 2019/11/21
 */
public class JdbcHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(JdbcHelper.class);

    private Connection connection = null;
    private PreparedStatement ps = null;

    public JdbcHelper() {
        init();
    }

    // 创建连接
    private void init() {
        try {
            Class.forName(JdbcConf.DRIVER);
            connection = DriverManager.getConnection(JdbcConf.URL, JdbcConf.USER, JdbcConf.PASSWORD);
        } catch (ClassNotFoundException e) {
            LOGGER.error("JdbcUtils init error, ", e);
            e.printStackTrace();
        } catch (SQLException e) {
            LOGGER.error("JdbcUtils init error, {}", e);
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * 查询
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet query(String sql) throws SQLException {
        ps = getConnection().prepareStatement(sql);
        return ps.executeQuery();
    }

    /**
     * 执行
     * @param sql
     * @return
     * @throws SQLException
     */
    public Boolean exec(String sql) throws SQLException {
        ps = getConnection().prepareStatement(sql);
        return ps.execute();
    }

    /**
     * 关闭连接
     */
    public void close() {
        try {
            if (ps != null) {
                ps.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.error("JdbcUtils init close, {}", e);
            e.printStackTrace();
        }
    }
}
