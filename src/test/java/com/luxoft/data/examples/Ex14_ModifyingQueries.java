package com.luxoft.data.examples;

import com.luxoft.data.examples.repositories.PersonManagementService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class Ex14_ModifyingQueries extends TestEnvironmentInit {
    @Test
    @Order(1)
    public void findAllSortedByName(@Autowired PersonManagementService personManagementService) {
        printTitle("Spring Data Ex.14; Modifying Queries");

        Launcher.printTitle("All people sorted by name before modifications.");
        personRepository.findAll(Sort.by("name"))
                .stream().forEach(Launcher::print);

        Launcher.printTitle("Declaring manipulating queries");
        personManagementService.updateNameTomasToTommy();

        Launcher.print(personRepository.findByFirstName("Tommy"));

    }

    @Test
    @Order(2)
    public void updateNameTomasToTommy(@Autowired PersonManagementService personManagementService) {
        printTitle("Spring Data Ex.14; Modifying Queries");

        Launcher.printTitle("Declaring manipulating queries");
        personManagementService.updateNameTomasToTommy();

        Launcher.print(personRepository.findByFirstName("Tommy"));

    }

    @Test
    @Order(3)
    public void deleteAllByNameStartingWithI(@Autowired PersonManagementService personManagementService) {
        printTitle("Spring Data Ex.14; Modifying Queries");

        Launcher.printTitle("Derived Delete Queries");
        personManagementService.deleteAllByName();

        personRepository.findAll(Sort.by("name"))
                .stream()
                .map(person -> person.getName())
                .forEach(Launcher::print);

    }

}
