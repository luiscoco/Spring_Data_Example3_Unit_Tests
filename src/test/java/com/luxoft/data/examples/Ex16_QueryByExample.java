package com.luxoft.data.examples;

import com.luxoft.data.examples.model.Address;
import com.luxoft.data.examples.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@SpringBootTest
public class Ex16_QueryByExample extends TestEnvironmentInit {

    @Test
    public void findPersonWithSpecificName() {

        printTitle("Spring Data Ex.16; Query by Example");

        Person person = new Person();
        person.setName("Mike");

        Launcher.printTitle("Find person with name Mike");

        Example<Person> example = Example.of(person);
        personRepository
                .findAll(example)
                .stream()
                .forEach(Launcher::print);
    }

    @Test
    public void findPeopleWithNameStartsWithI() {

        Person person = new Person();
        person.setName("I");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", m -> m.startsWith());

        Launcher.printTitle("Find person with name starts with I");

        Example<Person> example = Example.of(person, matcher);

        personRepository.findAll(example).stream().forEach(Launcher::print);
    }


    @Test
    public void findPersonWithSpecificNameAndAge() {

        printTitle("Spring Data Ex.16; Query by Example");

        Person person = new Person();
        person.setName("Mike");
        person.setAge(16);

        Launcher.printTitle("Find person with name: Mike and age: 16");

        personRepository.findAll(Example.of(person)).stream()
                .forEach(Launcher::print);
    }

    @Test
    public void findPeopleByNameUsingMatcher() {
        printTitle("Spring Data Ex.16; Query by Example");

        Person person = new Person();
        person.setName("I");
        person.setAge(21);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", m -> m.startsWith());

        Launcher.printTitle("Find person with name starts with I");

        Example<Person> example = Example.of(person, matcher);

        personRepository.findAll(example)
                .stream()
                .forEach(Launcher::print);
    }

    @Test
    public void findPeopleFromSpecificStreet() {
        printTitle("Spring Data Ex.16; Query by Example");

        Person person = new Person();

        Address address = new Address();
        address.setStreet("Gogol");

        person.setAddress(address);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("address.street", m -> m.startsWith());

        Launcher.printTitle("Find people from specific street.");

        Example<Person> example = Example.of(person, matcher);

        personRepository.findAll(example)
                .stream()
                .forEach(Launcher::print);
    }

    @Test
    public void findPeopleByNameStartingStringMatcher() {
        printTitle("Spring Data Ex.16; Query by Example");

        Person person = new Person();
        person.setName("i");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();

        Launcher.printTitle("Find person with name starts with i, with ignore case.");

        Example<Person> example = Example.of(person, matcher);

        personRepository.findAll(example)
                .stream()
                .forEach(Launcher::print);
    }


}
