package cn.wangz.clientutil.hbase;

import cn.wangz.clientutil.util.ExceptionUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Created by hadoop on 2018/1/23.
 */
public class HBaseHelper {
    private static Logger logger = Logger.getLogger(HBaseHelper.class);

    private static HBaseHelper instance;

    public static HBaseHelper getInstance() {
        if (instance == null) {
            synchronized (HBaseHelper.class) {
                if (instance == null) {
                    try {
                        instance = new HBaseHelper(HBaseConf.zkClinePort, HBaseConf.zkQuorum);
                    } catch (Exception e) {
                        String errMsg = ExceptionUtil.stackTraceMsg(e);
                        logger.error(errMsg);
                    }
                }
            }
        }
        return instance;
    }

    private Configuration conf = HBaseConfiguration.create();
    private Connection connection = null;
    private HBaseAdmin hbaseAdmin = null;

    public HBaseHelper(int zkClinePort, String zkQuorum) throws IOException {
        conf.set("hbase.zookeeper.property.clientPort", String.valueOf(zkClinePort));
        conf.set("hbase.zookeeper.quorum", zkQuorum);

        connection = ConnectionFactory.createConnection(conf);
        hbaseAdmin = (HBaseAdmin) connection.getAdmin();
    }

    public boolean tableExists(String tableName) throws IOException {
        return hbaseAdmin.tableExists(tableName);
    }

    public boolean valueExists(String tableName, Get get) throws IOException {
        HTable table = null;
        try {
            table = (HTable) connection.getTable(TableName.valueOf(tableName));
            return table.exists(get);
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    public void putData(String tableName, Put put) throws IOException {
        HTable table = null;
        try {
            table = (HTable) connection.getTable(TableName.valueOf(tableName));
            table.put(put);
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    public void batch(String tableName, List<Mutation> list) throws Exception {
        HTable table = null;
        try {
            table = (HTable) connection.getTable(TableName.valueOf(tableName));
            Object[] results = new Object[list.size()];
            table.batch(list, results);
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    public Result getData(String tableName, Get get) throws IOException {
        HTable table = null;
        try {
            table = (HTable) connection.getTable(TableName.valueOf(tableName));
            return table.get(get);
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    public void delete(String tableName, Delete delete) throws IOException {
        HTable table = null;
        try {
            table = (HTable) connection.getTable(TableName.valueOf(tableName));
            table.delete(delete);
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    public void close() throws IOException {
        if (hbaseAdmin != null) {
            hbaseAdmin.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
