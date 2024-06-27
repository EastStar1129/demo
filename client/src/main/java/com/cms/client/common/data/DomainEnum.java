package com.cms.client.common.data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DomainEnum {
    bulletin, worship;

    private static final String PATH_BULLETIN = "/volume1/youngseok/upload/bulletin";

    public String getPath() {
        return switch (this) {
            case bulletin -> PATH_BULLETIN;
            default -> throw new IllegalArgumentException("no enum path");
        };
    }
}
