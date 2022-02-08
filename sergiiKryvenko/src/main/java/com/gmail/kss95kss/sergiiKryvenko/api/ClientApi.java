package com.gmail.kss95kss.sergiiKryvenko.api;

import com.gmail.kss95kss.sergiiKryvenko.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller
@RequestMapping(value = ("/login"))
public class ClientApi {

    private final ClientService clientService;

    public ClientApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = ("/login"))
    public String logIn(@RequestParam(value = "login", required = false) String login, @RequestParam(value = "password", required = false) String password, Model model) {


        {


            return "login/login_user";
        }
    }
}
