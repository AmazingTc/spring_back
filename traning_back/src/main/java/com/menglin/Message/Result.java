package com.menglin.Message;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;
    private Object data2;
    private Object token;
    public Result(RequestCode requestCode, Object data) {
        this.code = requestCode.getCode();
        this.message = requestCode.getMessage();
        this.data = data;
    }
    public Result(RequestCode requestCode,Object data,Object data2,Object token){
        this.code = requestCode.getCode();
        this.message = requestCode.getMessage();
        this.data = data;
        this.data2 = data2;
        this.token = token;
    }

}
