package com.cms.admin.common.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS("0000"),
    LOGIN_FAIL("1000"),
    SIGNUP_ALREADY_USERNAME_FAIL("1001"),
    UPLOAD_FAIL("4000"),
    FAIL("9999");

    private final String code;
}
