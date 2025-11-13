package com.luxoft.data.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ex19_DeleteQueries extends TestEnvironmentInit {

    @Test
    public void deleteAllByName() {
        printTitle("Spring Data Ex.19; Delete Queries");

        Launcher.printTitle("Delete all persons by name.");


        String name = "Ben";
        Assertions.assertTrue(personRepository.findByName(name).size() == 1);

        personRepository.deleteAllByName(name);

        Assertions.assertTrue(personRepository.findByName(name).size() == 0);
    }

    @Test
    public void deleteAllByAddress_ZipCodeCodeValue() {
        printTitle("Spring Data Ex.19; Delete Queries");

        Launcher.printTitle("Delete all persons by Zip Code.");

        int codeValue = 111;

        Assertions.assertTrue(personRepository.findAll().size() == 11);

        personRepository.deleteAllByAddress_ZipCodeCodeValue(codeValue);

        Assertions.assertTrue(personRepository.findAll().size() == 6);
    }

}
