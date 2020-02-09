package com.springframework.springclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"/", "/index", "/owners/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
