package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.trainers.bo.Pokemon;
import com.ifi.trainer_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private String url;
    private RestTemplate restTemplate;
    private PokemonTypeService pokemonTypeService;

    public List<Trainer> listTrainers(String name) {
        var url = this.url + "/trainers/all/" + name;
        Trainer[] l = restTemplate.getForObject(url, Trainer[].class);
        List<Trainer> list = Arrays.asList(l);

        for (Trainer t : list) {
            t = this.addTeam(t);
        }
        return list;
    }

    public Trainer getTrainer(String name) {
        var url = this.url + "/trainers/" + name;
        Trainer t = restTemplate.getForObject(url, Trainer.class);
        t = this.addTeam(t);
        return t;
    }

    private Trainer addTeam(Trainer t){
        for (Pokemon p: t.getTeam()) {
            p.setPokemonType(pokemonTypeService.getPokemonType(p.getPokemonType()));
        }
        return t;
    }

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")
    void setTrainerServiceUrl(String trainerServiceUrl) {
        this.url = trainerServiceUrl;
    }

    @Autowired
    void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }
}