package com.cms.demo.user.exception;

public class UsernameAlreadyFoundException extends RuntimeException {
    public UsernameAlreadyFoundException() { super("already signed up id");}
}
