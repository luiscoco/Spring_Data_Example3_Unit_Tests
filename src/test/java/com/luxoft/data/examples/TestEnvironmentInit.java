package com.luxoft.data.examples;

import com.luxoft.data.examples.model.Address;
import com.luxoft.data.examples.model.HappyPerson;
import com.luxoft.data.examples.model.Person;
import com.luxoft.data.examples.model.ZipCode;
import com.luxoft.data.examples.repositories.AddressRepository;
import com.luxoft.data.examples.repositories.HappyPersonRepository;
import com.luxoft.data.examples.repositories.PersonRepository;
import com.luxoft.data.examples.repositories.ZipCodeRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;

abstract class TestEnvironmentInit {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ZipCodeRepository zipCodeRepository;

    @BeforeAll
    static void beforeAll(@Autowired PersonRepository personRepository,
                          @Autowired AddressRepository addressRepository,
                          @Autowired ZipCodeRepository zipCodeRepository,
                          @Autowired HappyPersonRepository happyPersonRepository) {

        ZipCode zipCode1 = zipCodeRepository.save(new ZipCode(111));
        ZipCode zipCode2 = zipCodeRepository.save(new ZipCode(222));

        Address address11 = addressRepository.save(new Address("Darwin Street", "Kiev", zipCode1));
        Address address12 = addressRepository.save(new Address("Defence Street", "Kiev", zipCode1));
        Address address13 = addressRepository.save(new Address("Distant street", "Kiev", zipCode1));

        Address address21 = addressRepository.save(new Address("Gas Street", "Kiev", zipCode2));
        Address address22 = addressRepository.save(new Address("Gastello Street", "Kiev", zipCode2));
        Address address23 = addressRepository.save(new Address("Gogol street", "Kiev", zipCode2));

        personRepository.save(new Person("Ivan", 21, address11));
        personRepository.save(new Person("Alex", 27, address12));
        personRepository.save(new Person("Alex", 21, address12));
        personRepository.save(new Person("Tomas", 21, address13));
        personRepository.save(new Person("Irina", 18, address21));
        personRepository.save(new Person("Anna", 21, address22));

        personRepository.save(new Person("Toma", 35, address23));
        personRepository.save(new Person("Ben", 38, address23));
        personRepository.save(new Person("Mike", 16, address23));
        personRepository.save(new Person("Ibrahim", 39, address12));

        happyPersonRepository.save(new HappyPerson("Ivan"));

        printTitle("Data - Generated");
    }

    @AfterAll
    public static void afterAll(@Autowired PersonRepository personRepository,
                                @Autowired AddressRepository addressRepository,
                                @Autowired ZipCodeRepository zipCodeRepository) {

        personRepository.deleteAll();
        addressRepository.deleteAll();
        zipCodeRepository.deleteAll();
    }


    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void printTitle(String s) {
        System.out.println("\n==========================");
        System.out.println(s);
        System.out.println("==========================");
    }
}
