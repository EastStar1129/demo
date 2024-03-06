package com.cms.demo.common.exception;

public class FailedFileUploadException extends RuntimeException{
    public FailedFileUploadException(Exception e) {super("Failed File Upload", e);}
}
