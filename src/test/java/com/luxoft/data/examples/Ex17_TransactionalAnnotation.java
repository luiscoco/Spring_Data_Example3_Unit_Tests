package com.luxoft.data.examples;

import com.luxoft.data.examples.model.Address;
import com.luxoft.data.examples.model.Person;
import com.luxoft.data.examples.repositories.PersonManagementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Ex17_TransactionalAnnotation extends TestEnvironmentInit {

    @Autowired
    private PersonManagementService personManagementService;

    @Test
    public void createPersonAndAddressSuccess() {

        printTitle("Spring Data Ex.17; Transactional annotation demo");

        Person person = new Person();
        person.setName("Mike");

        String city = "AAA";
        Address address = new Address();
        address.setCity(city);
        address.setStreet("Stone");

        Launcher.printTitle("Create person with name Mike and address with city " + city);

        Person savedPerson = personManagementService.savePersonAndAddress(person, address);

        System.out.println(savedPerson);

        List<Address> addressList = addressRepository.findAddressByCity(city);

        Assertions.assertTrue(addressList.size() == 1);

    }

    @Test
    public void createPersonAndAddressFailure() {

        printTitle("Spring Data Ex.17; Transactional annotation demo");

        Person person = new Person();
        person.setName("Zak");

        String city = "AAA";
        Address address = new Address();
        address.setCity(city);
        address.setStreet("Stone");

        Launcher.printTitle("Create person with name Zak and address with city " + city);

        Assertions.assertThrows(IllegalStateException.class, () ->
                personManagementService.savePersonAndAddress(person, address));

        List<Address> addressList = addressRepository.findAddressByCity(city);

        Assertions.assertTrue(addressList.size() == 0);
    }

}
