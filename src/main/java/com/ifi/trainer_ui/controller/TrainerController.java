package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//public class TrainerController {
//
//    private PokemonTypeService pokemonTypeService;
//
//    @GetMapping("/trainers")
//    public ModelAndView pokedex(){
//        var modelAndView = new ModelAndView("trainers");
//        modelAndView.addObject("trainerTypes", this.pokemonTypeService.listPokemonsTypes());
//        return modelAndView;
//    }
//
//    @Autowired
//    public void setPokemonTypeService(PokemonTypeService pokemonTypeService){
//        this.pokemonTypeService = pokemonTypeService;
//    }
//
//}