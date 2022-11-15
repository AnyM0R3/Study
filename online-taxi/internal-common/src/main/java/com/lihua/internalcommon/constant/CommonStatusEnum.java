package com.lihua.internalcommon.constant;


import lombok.Getter;

public enum CommonStatusEnum {

    // 成功
    SUCCESS(1, "success"),
    // 失败
    FAIL(0, "fail")

    ;

    @Getter
    private int code;
    @Getter
    private String message;

    CommonStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
