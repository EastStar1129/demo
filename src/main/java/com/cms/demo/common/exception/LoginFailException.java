package com.cms.demo.common.exception;

public class LoginFailException extends RuntimeException{
    public LoginFailException() {super("로그인에 실패했습니다.");}
}
