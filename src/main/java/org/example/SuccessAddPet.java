package org.example;

import java.util.ArrayList;
import io.qameta.allure.Step;

public class SuccessAddPet extends PetsAdd{
    private ArrayList<Tag> tags;

    public SuccessAddPet(Integer id, String name, ArrayList<String> photoUrls, ArrayList<Tag> tags) {
        super(id,name, photoUrls);
        this.tags = tags;
    }

    public SuccessAddPet() {
        super();
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

}
