package com.ifi.trainer_ui.trainers.bo;

import java.util.List;

public class Trainer {

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    private String name;

    private List<Pokemon> team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }
}