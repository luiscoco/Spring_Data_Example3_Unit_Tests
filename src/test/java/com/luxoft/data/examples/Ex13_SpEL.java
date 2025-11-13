package com.luxoft.data.examples;

import com.luxoft.data.examples.repositories.HappyPersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ex13_SpEL extends TestEnvironmentInit {

    @Autowired
    private HappyPersonRepository happyPersonRepository;

    @Test
    public void findByUsingSpEL() {
        printTitle("Spring Data Ex.13; Using SpEL Expressions");

        print(personRepository.findBySpel("Tomas"));
        print("====");
        print(happyPersonRepository.findBySpel("Ivan"));
    }
}
