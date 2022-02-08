package com.gmail.kss95kss.sergiiKryvenko.api;

import com.gmail.kss95kss.sergiiKryvenko.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(name = "/registration")
public class RegistrarionApi {
    public final RegistrationService registrationService;

    public RegistrarionApi(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping(name = "/registration")
    public String getRegistrationPage() {
        return "registration";

    }


    @PostMapping(name = "/add")
    public void setRegistration(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "secondName", required = false) String secondName,
                                @RequestParam(value = "login", required = false) String login,
                                @RequestParam(value = "password", required = false) String password,
                                @RequestParam(value = "rePassword", required = false) String rePassword,
                                @RequestParam(value = "email", required = false) String email,
                                @RequestParam(value = "gender", required = false) String gender,
                                @RequestParam(value = "address", required = false) String address,
                                @RequestParam(value = "agree", required = false) Integer agree,
                                Model model) {

        String errorText = "";
        Pattern patlatletter = Pattern.compile("[a-zA-Z]{1}");
        Matcher matlatletter;
        Matcher matcher;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
        int uperFlag = 0;
        int lowerFlag = 0;
        int digitFlag = 0;
        boolean onlyLatinAlphabet = true;

        Character ch;
        // errorText += "</ul>";
        boolean isError = false;
        boolean isShowForm = true;

        if (!Objects.isNull(login)) {
            if (login.length() < 1) {
                isError = true;
                errorText += "<li> login is empty </li>";
            }
            if (login.length() < 1) {
                isError = true;
                errorText += "<li> login is empty </li>";
            }
            matcher = emailPattern.matcher(email);
            if (!matcher.matches()) {
                isError = true;
                errorText += "<li> invalid email </li>";
            }
            if (password.length() < 1) {
                isError = true;
                errorText += "<li> password is empty </li>";
            }
            if (password.length() <= 8) {
                isError = true;
                errorText += "<li> password must contain 8+ symblos </li>";
            }
            char[] character = password.toCharArray();

            for (int i = 0; i < character.length; i++) {
                ch = character[i];
                if (Character.isUpperCase(ch)) {
                    uperFlag = +1;
                }
                if (Character.isLowerCase(ch)) {
                    lowerFlag = +1;
                }
                if (Character.isDigit(ch)) {
                    digitFlag = +1;
                }
            }
            if (uperFlag == 0) {
                isError = true;
                errorText += "<li> password must contain Upper case character </li>";
            }
            if (lowerFlag == 0) {
                isError = true;
                errorText += "<li> password must contain Lower case character  </li>";
            }
            if (digitFlag == 0) {
                isError = true;
                errorText += "<li> password must contain digit character </li>";
            }
            matlatletter = patlatletter.matcher(password);
            // if (!Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.BASIC_LATIN)) {
            if (matlatletter.matches()) {
                isError = true;
                errorText += "<li> password must contain only lat character </li>";
                //errorText += "<li>" + ch + " - is not lat character </li>";

            }
            onlyLatinAlphabet = password.matches("^[a-zA-Z0-9]+$");
            if (onlyLatinAlphabet = false) {
                errorText += "<li> password must contain only lat character </li>";
            }


            if (rePassword.length() < 1) {
                isError = true;
                errorText += "<li> re-password is empty </li>";
            }
            if (!Objects.equals(password, rePassword)) {
                isError = true;
                errorText += "<li> Those passwords do not match. Try again:  </li>";
            }
            if (name.length() < 1) {
                isError = true;
                errorText += "<li> name is empty </li>";
            }
            if (Objects.isNull(gender) || gender.length() < 1) {
                isError = true;
                errorText += "<li> gender is empty </li>";
            }
            if (address.length() < 1) {
                isError = true;
                errorText += "<li> address is empty </li>";
            }
            if (Objects.isNull(agree)) {
                isError = true;
                errorText += "<li> agree is empty </li>";
            }
            if (!isError) {
                errorText += "success";
                registrationService.registration(name,secondName,password,email,3);
                model.addAttribute("errorText",errorText);

            }

        }

    }
}


