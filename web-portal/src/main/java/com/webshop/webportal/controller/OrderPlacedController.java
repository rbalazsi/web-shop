package com.webshop.webportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderPlacedController {

    @RequestMapping("/orderPlaced")
    public String orderPlaced() {
        return "orderPlaced";
    }
}
