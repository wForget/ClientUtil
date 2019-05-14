package cn.wangz.clientutil.kudu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.kudu.ColumnSchema;
import org.apache.kudu.client.KuduException;
import org.apache.kudu.client.KuduTable;
import org.apache.kudu.client.Operation;
import org.apache.kudu.client.PartialRow;

import java.util.Collections;
import java.util.List;

public class JsonKuduOperationsProducer {

    public static List<Operation> getUpsertOperations(String json, KuduTable table) throws Exception {
        return getOperations(json, table, "upsert");
    }

    public static List<Operation> getInsertOperations(String json, KuduTable table) throws Exception {
        return getOperations(json, table, "insert");
    }

    public static List<Operation> getOperations(String json, KuduTable table, String type) throws Exception {
        if (StringUtils.isBlank(json)) return Collections.EMPTY_LIST;
        Operation op;
        if ("upsert".equals(type)) {
            op = table.newUpsert();
        } else if ("insert".equals(type)){
            op = table.newUpsert();
        } else {
            throw new Exception("operation type is illegal!");
        }

        setupOp(op, JSONObject.parseObject(json), table);
        return Collections.singletonList(op);
    }

    private static void setupOp(Operation op, JSONObject record, KuduTable table) throws Exception {
        PartialRow row = op.getRow();
        for (ColumnSchema col : table.getSchema().getColumns()) {
            String name = col.getName();
            Object value = record.get(name);
            if (value == null) {
                if (col.isNullable()) {
                    row.setNull(name);
                } else {
                    // leave unset for possible Kudu default
                }
            } else {
                // Avro doesn't support 8- or 16-bit integer types, but we'll allow them to be passed as
                // a larger type.
                try {
                    switch (col.getType()) {
                        case BOOL:
                            row.addBoolean(name, TypeUtils.castToBoolean(value));
                            break;
                        case INT8:
                            row.addByte(name, TypeUtils.castToByte(value));
                            break;
                        case INT16:
                            row.addShort(name, TypeUtils.castToShort(value));
                            break;
                        case INT32:
                            row.addInt(name, TypeUtils.castToInt(value));
                            break;
                        case INT64: // Fall through
                        case UNIXTIME_MICROS:
                            row.addLong(name, TypeUtils.castToLong(value));
                            break;
                        case FLOAT:
                            row.addFloat(name, TypeUtils.castToFloat(value));
                            break;
                        case DOUBLE:
                            row.addDouble(name, TypeUtils.castToDouble(value));
                            break;
                        case STRING:
                            row.addString(name, TypeUtils.castToString(value));
                            break;
                        case BINARY:
                            row.addBinary(name, TypeUtils.castToBytes(value));
                            break;
                        default:
                            throw new Exception(String.format(
                                    "Unrecognized type %s for column %s", col.getType().toString(), name));
                    }
                } catch (ClassCastException e) {
                    throw new Exception(
                            String.format("Failed to coerce value for column '%s' to type %s",
                                    col.getName(),
                                    col.getType()), e);
                }
            }
        }
    }
}
