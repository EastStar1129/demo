package com.cms.client.common.dto;

import com.cms.client.common.data.ResponseCode;
import lombok.Getter;

import java.util.Objects;

@Getter
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
        return new ResponseDto<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.toString());
    }

    public static ResponseDto<String> ofLoginFail(Exception e) {
        return new ResponseDto<>(ResponseCode.LOGIN_FAIL.getCode(), ResponseCode.LOGIN_FAIL.toString(), e.getMessage());
    }

    public static <T> ResponseDto<T> ofSuccess(T object) {
        return new ResponseDto<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.toString(), object);
    }
}
