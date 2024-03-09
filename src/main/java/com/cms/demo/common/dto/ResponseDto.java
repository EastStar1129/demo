package com.cms.demo.common.dto;

import com.cms.demo.common.data.ResponseCode;
import com.cms.demo.worship.entity.Worship;
import lombok.Getter;

import java.util.List;
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
        return new ResponseDto(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.toString());
    }
    public static ResponseDto ofUploadFail() {
        return new ResponseDto(ResponseCode.UPLOAD_FAIL.getCode(), ResponseCode.UPLOAD_FAIL.toString());
    }

    public static <T> ResponseDto<T> ofSuccess(T object) {
        return new ResponseDto<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.toString(), object);
    }
}
