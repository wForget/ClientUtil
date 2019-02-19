package cn.wangz.clientutil.phoenix;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hadoop on 2019/2/18.
 */
public class PhoenixDbcpUtils {
    private static BasicDataSource dataSource = null;
    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.apache.phoenix.jdbc.PhoenixDriver");
        dataSource.setUrl("jdbc:phoenix:dmp-test01,dmp-test02,dmp-test03:2181");
    }

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = dataSource.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 查询
//    public static ResultSet executeQuery(String sql) throws SQLException {
//        Connection connection = getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        return preparedStatement.executeQuery();
//    }

    public static void release(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.commit();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static final String QUERY_SQL = "select * from pubg.match_index where QUEUESIZE = 8 limit 10";
    public static List<MatchIndex> queryMatchIndex() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(QUERY_SQL);
            resultSet = preparedStatement.executeQuery();
            List<MatchIndex> matchIndexList = new ArrayList<>();
            while (resultSet.next()) {
                MatchIndex matchIndex = new MatchIndex();
                matchIndex.setLowerNickName(resultSet.getString("LOWERNICKNAME"));
                matchIndex.setMode(resultSet.getString("MODE"));
                matchIndex.setQueueSize(resultSet.getInt("QUEUESIZE"));
                matchIndex.setType(resultSet.getString("TYPE"));
                matchIndex.setMatchId(resultSet.getString("MATCHID"));
                matchIndex.setStartedAt(resultSet.getTimestamp("STARTEDAT"));
                matchIndex.setTotalRank(resultSet.getInt("TOTALRANK"));
                matchIndexList.add(matchIndex);
            }
            return matchIndexList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            release(resultSet, preparedStatement, connection);
        }
    }

    private static final String UPSERT_SQL= "UPSERT INTO PUBG.MATCH_INDEX(LOWERNICKNAME, STARTEDAT, MATCHID, MODE, QUEUESIZE, TOTALRANK, TYPE) VALUES (?, ?, ?, ?, ? ,?, ?)";
    public static void insertMatchIndexMany(List<MatchIndex> matchIndexList) throws SQLException {
        if (matchIndexList == null || matchIndexList.isEmpty()) return;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPSERT_SQL);
        for (MatchIndex matchIndex: matchIndexList) {
            preparedStatement.setObject(1, matchIndex.getLowerNickName());
            preparedStatement.setObject(2, new java.sql.Date(matchIndex.getStartedAt().getTime()));
            preparedStatement.setObject(3, matchIndex.getMatchId());
            preparedStatement.setObject(4, matchIndex.getMode());
            preparedStatement.setObject(5, matchIndex.getQueueSize());
            preparedStatement.setObject(6, matchIndex.getTotalRank());
            preparedStatement.setObject(7, matchIndex.getType());
            preparedStatement.execute();
        }
        connection.commit();
        release(null, preparedStatement, connection);
    }

    public static void main(String[] args) throws SQLException {
//        List<MatchIndex> matchIndexList = new ArrayList<>();
//        MatchIndex matchIndex1 = new MatchIndex();
//        matchIndex1.setLowerNickName("test1");
//        matchIndex1.setMode("tpp");
//        matchIndex1.setQueueSize(8);
//        matchIndex1.setType("office");
//        matchIndex1.setMatchId("test1");
//        matchIndex1.setStartedAt(DateTime.parse("2018-12-16T13:04:33.000+00:00").toDate());
//        matchIndex1.setTotalRank(90);
//        matchIndexList.add(matchIndex1);
//        MatchIndex matchIndex2 = new MatchIndex();
//        matchIndex2.setLowerNickName("test2");
//        matchIndex2.setMode("tpp");
//        matchIndex2.setQueueSize(8);
//        matchIndex2.setType("office");
//        matchIndex2.setMatchId("test2");
//        matchIndex2.setStartedAt(DateTime.parse("2018-12-16T13:04:33.000+08:00").toDate());
//        matchIndex2.setTotalRank(85);
//        matchIndexList.add(matchIndex2);
//        PhoenixDbcpUtils.insertMatchIndexMany(matchIndexList);
//        PhoenixDbcpUtils.close();

//        List<MatchIndex> matchIndexList = PhoenixDbcpUtils.queryMatchIndex();
//        matchIndexList.stream().forEach(matchIndex -> {
//            System.out.println(matchIndex);
//            System.out.println(matchIndex.getStartedAt().getTime());
//        });
    }

    @Getter
    @Setter
    static class MatchIndex {
        private String lowerNickName;
        private String mode;
        private Integer queueSize;
        private String type;
        private Date startedAt;
        private String matchId;
        private Integer totalRank;
    }
}
