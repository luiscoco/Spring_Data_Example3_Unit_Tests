package com.luxoft.data.examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ex10_NativeQuery extends TestEnvironmentInit {
    @Test
    public void findByNameNativeI() {
        printTitle("Spring Data Ex.10; Native Queries");

        personRepository.findByNameNative("I")
                .stream()
                .forEach(Launcher::print);

    }
}
