package com.example.jingtao.entity;

public class ResultEntity {
    private int code;
    private String msg;
    private Object data;

    public ResultEntity(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public static ResultEntity success(String msg, Object data) {
        return new ResultEntity(1, msg, data);
    }

    public static ResultEntity error(String msg, Object data) {
        return new ResultEntity((-1), msg, data);
    }

    public static ResultEntity login(String msg, Object data) {
        return new ResultEntity(0, msg, data);
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
