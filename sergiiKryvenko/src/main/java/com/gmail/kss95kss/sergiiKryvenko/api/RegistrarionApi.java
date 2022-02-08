package com.gmail.kss95kss.sergiiKryvenko.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/registration")
public class RegistrarionApi {
    @GetMapping(name = "/registration")
    public String getRegistrationPage()
    {
        return "registration";

    }






}
