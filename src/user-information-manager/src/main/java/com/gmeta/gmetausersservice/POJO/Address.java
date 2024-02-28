package com.gmeta.gmetausersservice.POJO;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Address")
@Data
public class Address {
    @Id
    @Column(name = "Address_ID")
    private String addressID;
    @Column(name = "Street_Name")
    private String street;
    @Column(name = "Street_Number")
    private String streetNumber;
    @Column(name = "City")
    private String city;
    @Column(name = "Postal_Code")
    private String postalCode;

    public Address() {}

    public Address(String street, String streetNumber, String city, String postalCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Address(Address address) {
    }
}
