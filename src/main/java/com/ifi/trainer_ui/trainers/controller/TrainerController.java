package com.ifi.trainer_ui.trainers.controller;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TrainerController {

    private TrainerService trainerService;

    @GetMapping("/trainers")
    public ModelAndView trainers(){
        var modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainersList", this.trainerService.listTrainers());
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
}
