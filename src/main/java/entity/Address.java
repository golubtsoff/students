package entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Embeddable
public class Address {

    @Column(name="street")
    private String street;

    public Address(){}

    public Address(String street){
        this.street = street;
    }

    @Getter
    public String getStreet() {
        return street;
    }

    @Setter
    public void setStreet(String street) {
        this.street = street;
    }

}
