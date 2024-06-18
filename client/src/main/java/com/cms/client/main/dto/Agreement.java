package com.cms.client.main.dto;

public class Agreement {
    private String hText;
    private String divText;

    public Agreement(String hText, String divText) {
        this.hText = hText;
        this.divText = divText;
    }

    public String gethText() {
        return hText;
    }

    public String getDivText() {
        return divText;
    }
}
