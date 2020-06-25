package com.codegym.cms.controller;

import com.codegym.cms.model.User;
import com.codegym.cms.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "/create";
    }

    @PostMapping("/registration")
    public String reg(@Valid @ModelAttribute("user")User user, BindingResult bindingResult, Model model){
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/create";
        }
        else {
            model.addAttribute("user", user);
            return "/index";
        }
    }


}
