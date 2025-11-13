package com.luxoft.data.examples;


import com.luxoft.data.examples.model.ZipCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex3_PropertyExpressions extends TestEnvironmentInit {
    @Test
    public void propertyExpressions() {
        printTitle("Spring Data Ex.3; Property Expressions");

        ZipCode zipCode = zipCodeRepository
                .findByCodeValue(111);

        personRepository
                .findByAddress_ZipCode(zipCode)
                .forEach(Launcher::print);
    }
}
