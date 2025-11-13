package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AbstractRepository<T extends Person> extends JpaRepository<T, Long> {

    @Query("select p from #{#entityName} p where p.name = ?1")
    T findBySpel(@Param("name") String name);
}
