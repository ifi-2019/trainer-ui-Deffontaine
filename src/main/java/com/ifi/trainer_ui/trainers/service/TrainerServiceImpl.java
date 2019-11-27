package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private String url;
    private RestTemplate restTemplate;

    public List<Trainer> listTrainers() {
        var url = this.url + "/trainers/";
        Trainer[] l = restTemplate.getForObject(url, Trainer[].class);
        List<Trainer> list = Arrays.asList(l);
//        System.out.println(list.get(0).getName());
//        list.sort((a,b)->a.getId()-b.getId());
        return list;
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")
    void setTrainerServiceUrl(String trainerServiceUrl) {
        this.url = trainerServiceUrl;
    }
}