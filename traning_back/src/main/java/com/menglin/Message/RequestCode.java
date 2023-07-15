package com.menglin.Message;

public enum RequestCode {
    SUCCESS(2000,"成功"),
    FAILURE(2001,"失败");
    private Integer code;
    private String message;
    RequestCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }


}
