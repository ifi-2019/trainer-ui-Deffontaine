package com.ifi.trainer_ui.trainers.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class SecurityControllerAdvice {

    @ModelAttribute("user")
    public Object principal(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getPrincipal();

    }

}