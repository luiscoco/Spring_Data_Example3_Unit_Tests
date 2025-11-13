package com.luxoft.data.examples;

import com.luxoft.data.examples.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
public class Ex6_LimitingQueryResults extends TestEnvironmentInit {
    @Test
    public void findFirst2ByAddress_Street() {
        printTitle("Spring Data Ex.6; Limiting Query Results");

        printTitle("findFirst2ByAddress_Street");
        personRepository.findFirst2ByAddress_Street("Gogol street")
                .forEach(Launcher::print);

    }

    @Test
    public void findAllPageOne() {
        printTitle("Spring Data Ex.6; Limiting Query Results");

        printTitle("findAll");
        Page<Person> personPage = personRepository
                .findAll(PageRequest.of(1, 3));

        personPage
                .get()
                .forEach(Launcher::print);
    }

    @Test
    public void findFirstByOrderByNameAsc() {
        printTitle("Spring Data Ex.6; Limiting Query Results");

        printTitle("findFirstByOrderByNameAsc");
        print(personRepository.findFirstByOrderByNameAsc());
    }
}
