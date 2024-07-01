package org.example;

import io.qameta.allure.Step;

public class UpdatePet {
    private Integer id;
    private String name;

    public UpdatePet(String name) {
        this.name = name;
    }

    public UpdatePet() {
        super();
    }

    public String getName() {
        return name;
    }
}
