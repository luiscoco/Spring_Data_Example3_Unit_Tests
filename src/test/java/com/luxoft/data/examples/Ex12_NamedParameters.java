package com.luxoft.data.examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ex12_NamedParameters extends TestEnvironmentInit {
    @Test
    public void findByFirstNameUsingNamedParameters() {
        printTitle("Spring Data Ex.12; Using Named Parameters");

        print(personRepository.findByFirstName("Tomas"));
    }
}
