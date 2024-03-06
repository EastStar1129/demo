package com.cms.demo.admin.controller;

import com.cms.demo.worship.service.WorshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminWebController {
    private final WorshipService worshipService;
    private static final String PREFIX_PATH = "/admin/";

    @GetMapping("/worship")
    public String worship() {
        return path("worship");
    }
    @GetMapping("/bulletin")
    public String bulletin() {
        return path("bulletin");
    }

    private static String path(String endpoint) {
        return PREFIX_PATH + endpoint;
    }
}
