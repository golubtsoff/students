package entity;

import javax.persistence.*;

@Embeddable
public class Address {

    @Column(name="street")
    private String street;

    @Column(name="building")
    private int building;

    public Address(){}

    public Address(String street, int building){
        this.street = street;
        this.building = building;
    }
}
