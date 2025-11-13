package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

@Service
public class AddressManagementService {

    @Autowired
    private AddressRepository repository;

    @Transactional(readOnly = true)
    public void findAllFromStream() {

        try (Stream<Address> stream = repository.findAllByCustomQueryAndStream()) {

            stream.map(a -> a.getStreet())
                    .forEach(System.out::println);
        }
    }

    public void findByStreetAsync(String street) {

        try {

            Future<List<Address>> future = repository.findByStreet(street);
            System.out.println("Do some another work...");
            for (int i=0;i<1000; i++) {
                System.out.println(future.isDone());
                Thread.sleep(10);
                if (future.isDone()) break;
            }
            System.out.println("Result is ready!");
            future.get().forEach(System.out::println);

        } catch (InterruptedException | ExecutionException e) {

            e.printStackTrace();
        }
    }

    public void findByCityAsync(String city) {

        repository.findByCity(city)
                .thenAcceptAsync(list -> list.stream()
                        .forEach(address ->
                                System.out.println(Thread.currentThread()
                                        + ": " + address)));

        System.out.println(Thread.currentThread()
                + ": Do some another work while searching by city...");
    }

}
