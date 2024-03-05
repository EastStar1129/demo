package com.cms.demo.common.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS("0000"),
    FAIL("9999");

    private final String description;
}
