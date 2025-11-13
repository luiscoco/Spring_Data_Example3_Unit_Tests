package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.model.Address;
import com.luxoft.data.examples.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface NullHandlingPersonRepository extends JpaRepository<Person, Long> {


    @NonNull Person getByAddress(@NonNull Address address);

    @Nullable
    Person findByAddress(@Nullable Address address);

    Optional<Person> findOptionalByAddress(@NonNull Address address);


}
