package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.model.Address;
import com.luxoft.data.examples.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonManagementService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    public void updateNameTomasToTommy() {
        personRepository.updateName("Tomas", "Tommy");
    }

    public void deleteAllByName() {
        personRepository.deleteAllByNameStartingWith("I");
    }

    /**
     * Repository save method called in transaction but in this case we
     * called 2 methods from different repositories and we want them to be
     * in one transaction.
     *
     * We want to avoid saving an address without a person.
     *
     * That is why we add the @Transactional annotation to this method.
     */
    @Transactional
    public Person savePersonAndAddress(Person person, Address address)
    {
        Address savedAddress = addressRepository.save(address);
        person.setAddress(savedAddress);

        if (person.getName().startsWith("Z"))
        {
            throw new IllegalStateException("Name can't start with letter Z");
        }

        return personRepository.save(person);
    }
}
