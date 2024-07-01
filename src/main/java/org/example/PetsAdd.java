package org.example;

import io.qameta.allure.Step;
import java.util.ArrayList;

public class PetsAdd {
    private Integer id;
    private String name;
    private ArrayList<String> photoUrls;

    public PetsAdd(Integer id, String name, ArrayList<String> photoUrls) {
        this.id = id;
        this.name = name;
        this.photoUrls = photoUrls;
    }
    @Step("Инициализация питомца")
    public static PetsAdd Add(Integer id,String name,String photoUrl){
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        return new PetsAdd(id,name,photoUrls);
    }

    public Integer getId() {
        return id;
    }

    public PetsAdd() {
        super();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }
}
