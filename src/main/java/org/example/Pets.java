package org.example;

import java.util.ArrayList;
import io.qameta.allure.Step;


public class Pets {
    private Integer id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;

    public Pets(Integer id, Category category, String name, ArrayList<String> photoUrls, ArrayList<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }
    @Step("Проверка соответствия ответа схеме")
    public static String setSchema(String urlSchema){
        return urlSchema;
    }
    @Step("Установка id питомца")
    public static Integer setId(Integer id) {
        return id;
    }
    @Step("Уставновка нового имени питомца")
    public static String setName(String name) {
        return name;
    }
    @Step("Установка статуса питомца")
    public static String setStatus(String status) {
        return status;
    }
}