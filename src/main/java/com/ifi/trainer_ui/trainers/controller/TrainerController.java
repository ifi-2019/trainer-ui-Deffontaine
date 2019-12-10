package com.ifi.trainer_ui.trainers.controller;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class TrainerController {

    private TrainerService trainerService;

    @GetMapping("/trainers")
    public ModelAndView trainers(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) auth.getPrincipal();
        var name = principal.getUsername();

        var modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainersList", this.trainerService.listTrainers(name));
        return modelAndView;
    }

    @GetMapping("/trainer/{name}")
    public ModelAndView trainer(@PathVariable String name){
        var modelAndView = new ModelAndView("trainer");
        modelAndView.addObject("trainerDetails", this.trainerService.getTrainer(name));
        return modelAndView;
    }

    @Autowired
    public void setTrainerService(TrainerService t){
        this.trainerService = t;
    }

    @GetMapping("/profile")
    public ModelAndView profile(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) auth.getPrincipal();
        var name = principal.getUsername();

        var modelAndView = new ModelAndView("profile");
        modelAndView.addObject("trainerProfile", this.trainerService.getTrainer(name));
        return modelAndView;
    }

}
