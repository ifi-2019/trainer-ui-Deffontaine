package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private String url;
    private RestTemplate restTemplate;

    public List<PokemonType> listPokemonsTypes() {
        var url = this.url + "/pokemon-types/";
        PokemonType[] l = restTemplate.getForObject(url, PokemonType[].class);
        List<PokemonType> list = Arrays.asList(l);
        list.sort((a,b)->a.getId()-b.getId());
        return list;
    }

    public PokemonType getPokemonType(int n) {
        var url = this.url + "/pokemon-types/" + n;
        PokemonType p = restTemplate.getForObject(url, PokemonType.class);
        return p;
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
       this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.url = pokemonServiceUrl;
    }
}