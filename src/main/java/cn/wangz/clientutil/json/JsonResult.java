package cn.wangz.clientutil.json;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hadoop on 2018/12/24.
 */
@Getter
@Setter
public class JsonResult<T> {

    private T data;
    private Integer code;
    private String msg;

    /**
     * 若没有数据返回，默认状态码为0，提示信息为：操作成功！
     */
    public JsonResult() {
        this.code = 0;
        this.msg = "Success";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回时，状态码为0，默认提示信息为：操作成功！
     * @param data
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = 0;
        this.msg = "Success";
    }

    /**
     * 有数据返回，状态码为0，人为指定提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
}
