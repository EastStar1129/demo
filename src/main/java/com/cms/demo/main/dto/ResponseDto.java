package com.cms.demo.main.dto;

import com.cms.demo.main.entity.ResponseCode;

public class ResponseDto<T> {
    private String code;
    private String message;
    private T data;

    public ResponseDto(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
