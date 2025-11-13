package com.luxoft.data.examples.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ZIP_CODE")
public class ZipCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CODE_VALUE", nullable = false)
    private Integer codeValue;

    @OneToMany(mappedBy = "zipCode", targetEntity = Address.class, fetch = FetchType.EAGER)
    private Set<Address> addresses;

    public ZipCode() {
    }

    public ZipCode(Integer codeValue) {
        this.codeValue = codeValue;
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "id=" + id +
                ", codeValue=" + codeValue +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(Integer codeValue) {
        this.codeValue = codeValue;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
