package com.huangkai.girl.enums;

public enum ResultEnum {
    UNKNOWN_ERROR(-1, "Unknown error"),
    SUCCESS(0, "Succeeded"),
    UNIVERSITY(100, "Are you still in university ?"),
    MASTER(101, "Are you still master ?"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
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
