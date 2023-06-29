package com.example.proyectazo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
    @RequestMapping({"/","/inicio"})
    public String inicio(){
        return "index";
    }
    @RequestMapping({"/login"})
    public String login(){
        return "login";
    }
    @RequestMapping({"/dashboard"})
    public String dashboard(){
        return "dashboard";
    }
}
