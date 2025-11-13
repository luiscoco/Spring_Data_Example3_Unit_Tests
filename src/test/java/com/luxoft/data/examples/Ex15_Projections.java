package com.luxoft.data.examples;

import com.luxoft.data.examples.model.Person;
import com.luxoft.data.examples.model.Projections;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Ex15_Projections extends TestEnvironmentInit {

    @Test
    public void interfaceProjection() {

        printTitle("Spring Data Ex.15; Interface Projection.");

        personRepository.findByAge(21)
                .stream()
                .map(ps -> ps.getId() + " --> " + ps.getInfo()
                        + " from " + ps.getAddress().getCity())
                .forEach(Launcher::print);
    }

    @Test
    public void classProjection() {
        printTitle("Spring Data Ex.15; Class Projection");

        List<Projections.NameOnly> data = personRepository.findByName("Mike");
        data.forEach(Launcher::print);
    }

    @Test
    public void dynamicProjection() {
        printTitle("Spring Data Ex.15; Dynamic Projection");

        List<Projections.NameOnly> names = personRepository.findByName(
                "Mike", Projections.NameOnly.class);
        List<Person> persons = personRepository.findByName("Mike", Person.class);

        names.forEach(Launcher::print);
        persons.forEach(Launcher::print);
    }

}
