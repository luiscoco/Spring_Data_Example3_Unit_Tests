package com.luxoft.data.examples.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "CITY", nullable = false)
    private String city;

    @OneToMany(mappedBy = "address", targetEntity = Person.class, fetch = FetchType.EAGER)
    private Set<Person> persons;

    @ManyToOne(targetEntity = ZipCode.class)
    @JoinColumn(name = "ZIP_CODE_ID")
    private ZipCode zipCode;

    public Address() {
    }

    public Address(String street, String city, ZipCode zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }
}
