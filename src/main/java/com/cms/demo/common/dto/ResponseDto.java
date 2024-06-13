package com.cms.demo.common.dto;

import com.cms.demo.common.data.ResponseCode;
import com.cms.demo.user.exception.UsernameAlreadyFoundException;
import lombok.Getter;

import java.io.IOError;
import java.io.IOException;
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
    public static ResponseDto<String> ofUploadFail(IOException e) {
        return new ResponseDto<>(ResponseCode.UPLOAD_FAIL.getCode(), ResponseCode.UPLOAD_FAIL.toString(), "업로드에 실패했습니다.");
    }
    public static ResponseDto<String> ofLoginFail(Exception e) {
        return new ResponseDto<>(ResponseCode.LOGIN_FAIL.getCode(), ResponseCode.LOGIN_FAIL.toString(), e.getMessage());
    }
    public static ResponseDto<String> ofSignupAlreadyUsernameFail(UsernameAlreadyFoundException e) {
        return new ResponseDto<>(ResponseCode.SIGNUP_ALREADY_USERNAME_FAIL.getCode(), ResponseCode.SIGNUP_ALREADY_USERNAME_FAIL.toString(), e.getMessage());
    }

    public static <T> ResponseDto<T> ofSuccess(T object) {
        return new ResponseDto<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.toString(), object);
    }
}
