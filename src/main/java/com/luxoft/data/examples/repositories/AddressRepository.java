package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.model.Address;
import com.sun.istack.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @NotNull
    Address findOneById(Long id);

    List<Address> findAllByCity(String city, Pageable pageable);

    @Query("select a from Address a")
    Stream<Address> findAllByCustomQueryAndStream();

    @Async
    Future<List<Address>> findByStreet(String street);

    @Async
    CompletableFuture<List<Address>> findByCity(String city);

    List<Address> findAddressByCity(String city);
}
