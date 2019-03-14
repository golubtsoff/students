package entity;

import javax.persistence.*;

@Embeddable
public class Hobby {
    private String description;

    public Hobby(){}

    public Hobby(String description){
        this.description = description;
    }
}
