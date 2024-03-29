package com.cms.demo.common.dto;

import com.cms.demo.common.data.ResponseCode;

import java.util.Objects;

public class ResponseDto<T> {
    private String code;
    private String message;
    private T data;

    public ResponseDto(String code, String message) {
        this(code, message, null);
    }

    public ResponseDto(String code, String message, T data) {
        this.code = Objects.requireNonNull(code);
        this.message = Objects.requireNonNull(message);
        this.data = data;
    }

    public static ResponseDto ofSuccess() {
        return new ResponseDto(ResponseCode.SUCCESS.getDescription(), ResponseCode.SUCCESS.getDescription());
    }
}
