package com.cms.admin.user.exception;

public class UsernameAlreadyFoundException extends RuntimeException {
    public UsernameAlreadyFoundException() { super("already signed up id");}
}
