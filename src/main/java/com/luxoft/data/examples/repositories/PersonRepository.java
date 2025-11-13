package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.model.Person;
import com.luxoft.data.examples.model.Projections;
import com.luxoft.data.examples.model.ZipCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonRepository extends AbstractRepository<Person> {

    List<Person> findByAddress_ZipCode(ZipCode zipCode);

    List<Person> findByAge(Integer age, Sort sort);

    List<Person> findFirst2ByAddress_Street(String street);

    Page<Person> findAll(Pageable pageable);

    Person findFirstByOrderByNameAsc();

    // QUERIES

    @Query("select p from Person p where p.name like ?1%")
    List<Person> finderByPrefix(String prefix);

    @Query(value = "SELECT * FROM PERSON p WHERE p.NAME like ?1%", nativeQuery = true)
    List<Person> findByNameNative(String prefix);

    @Query("select p.name, LENGTH(p.name) as fn_length from Person p where p.name like ?1%")
    List<Object[]> findByAsArrayAndSort(String name, Sort sort);

    @Query("select p from Person p where p.name = :firstname")
    Person findByFirstName(@Param("firstname") String name);

    @Transactional
    @Modifying
    @Query("update Person p set p.name = ?2 where p.name = ?1")
    int updateName(String oldName, String newName);

    @Transactional
    @Modifying
    @Query("delete from Person p where p.name like ?1%")
    void deleteAllByNameStartingWith(String prefix);

    // PROJECTIONS
    List<Projections.PersonSummary> findByAge(int age);

    List<Projections.NameOnly> findByName(String name);

    <T> List<T> findByName(String name, Class<T> type);

    @Transactional
    void deleteAllByName(String name);

    @Transactional
    void deleteAllByAddress_ZipCodeCodeValue(Integer codeValue);
}
