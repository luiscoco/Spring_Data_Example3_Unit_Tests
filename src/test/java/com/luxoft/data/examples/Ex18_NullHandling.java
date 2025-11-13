package com.luxoft.data.examples;

import com.luxoft.data.examples.model.Address;
import com.luxoft.data.examples.model.Person;
import com.luxoft.data.examples.repositories.NullHandlingPersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ex18_NullHandling extends TestEnvironmentInit {

    @Autowired
    private NullHandlingPersonRepository repository;

    @Test
    public void getByAddress1() {

        printTitle("Spring Data Ex.18; NullHandling");

        Address address = new Address();
        address.setCity("AAA");
        address.setStreet("aaa");

        Address savedAddress = addressRepository.save(address);

//        Assertions.assertThrows(IllegalArgumentException.class,
//                () -> repository.getByAddress(savedAddress));

        Person person = repository.getByAddress(savedAddress);
        System.out.println(person);
    }

    @Test
    public void findByAddress1() {

        printTitle("Spring Data Ex.18; NullHandling");

        Address address = new Address();
        address.setCity("AAA");
        address.setStreet("aaa");

        Address savedAddress = addressRepository.save(address);

//        Assertions.assertThrows(IllegalArgumentException.class,
//                () -> repository.getByAddress(savedAddress));

        Person person = repository.findByAddress(savedAddress);
        System.out.println(person);
    }

}
