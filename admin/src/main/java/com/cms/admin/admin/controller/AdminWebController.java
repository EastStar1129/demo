package com.cms.admin.admin.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminWebController {
    private static final String PREFIX_PATH = "main/";

    @GetMapping("/user")
    public String user() {
        return path("user");
    }

    @GetMapping("/worship")
    public String worship() {
        return path("worship");
    }

    @GetMapping("/bulletin")
    public String bulletin() {
        return path("bulletin");
    }

    @GetMapping({"/login", "/"})
    public String login(HttpSession session) {
        if (!Objects.isNull(session.getAttribute("user"))) {
            return "redirect:/worship";
        }

        return path("login");
    }

    private static String path(String endpoint) {
        return PREFIX_PATH + endpoint;
    }
}
