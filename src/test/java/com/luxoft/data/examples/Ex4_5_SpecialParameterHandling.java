package com.luxoft.data.examples;

import com.luxoft.data.examples.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class Ex4_5_SpecialParameterHandling extends TestEnvironmentInit {
    @Test
    public void specialParameterHandlingSort() {
        printTitle("Spring Data Ex.4; Special parameter handling. Sorting");

        Sort sort = Sort.sort(Person.class)
                .by(Person::getName)
                .descending();

        personRepository
                .findByAge(21, sort)
                .forEach(Launcher::print);
    }

    @Test
    public void specialParameterHandlingPaging() {
        printTitle("Spring Data Ex.5; Special parameter handling. Paging");

        addressRepository
                .findAllByCity("Kiev", PageRequest.of(1, 3, Sort.by("street")))
                .forEach(Launcher::print);
    }


}
