package com.luxoft.data.examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ex9_AdvancedLikeExpressions extends TestEnvironmentInit {
    @Test
    public void findByNameStartsWithI() {
        printTitle("Spring Data Ex.9; Using Advanced LIKE Expressions");

        personRepository.finderByPrefix("I")
                .stream()
                .forEach(Launcher::print);

    }
}
