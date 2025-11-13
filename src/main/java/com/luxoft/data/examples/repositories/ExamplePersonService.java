package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.Launcher;
import com.luxoft.data.examples.model.Address;
import com.luxoft.data.examples.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class ExamplePersonService {
    @Autowired
    private PersonRepository repository;

    public void runAllDemos() {
        findPeople();
        findPeopleWithNameStartsWithI();
        findPeopleFromSpecificStreet();
    }

    public void findPeople() {

        Person person = new Person();
        person.setName("Mike");

        Launcher.printTitle("Find person with name Mike");

        repository.findAll(Example.of(person)).stream()
                .forEach(Launcher::print);
    }

    public void findPeopleWithNameStartsWithI() {

        Person person = new Person();
        person.setName("I");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", m -> m.startsWith());

        Launcher.printTitle("Find person with name starts with I");

        Example<Person> example = Example.of(person, matcher);

        repository.findAll(example)
                .stream()
                .forEach(Launcher::print);
    }

    public void findPeopleFromSpecificStreet() {

        Person person = new Person();

        Address address = new Address();
        address.setStreet("Gogol");

        person.setAddress(address);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("address.street", m -> m.startsWith());

        Launcher.printTitle("Find people from specific street.");

        Example<Person> example = Example.of(person, matcher);

        repository.findAll(example)
                .stream()
                .forEach(Launcher::print);
    }

}
