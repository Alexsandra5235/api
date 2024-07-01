package org.example;

import java.beans.Introspector;

public class SuccessUpdatePet extends UpdatePet{
    private Integer code;
    private String type;
    private String message;

    public SuccessUpdatePet(String name, String status, Integer code, String type, String message) {
        super(name);
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public SuccessUpdatePet() {
        super();
    }

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
