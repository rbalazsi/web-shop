package com.webshop.webportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderPlacedController {

    @RequestMapping("/orderPlaced")
    public String orderPlaced(@RequestParam("success") boolean success) {
        return (success) ? "orderPlaced" : "orderFailed";
    }
}
