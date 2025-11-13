package com.luxoft.data.examples;

import com.luxoft.data.examples.repositories.AddressManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ex8_AsyncQueryResults extends TestEnvironmentInit {
    @Test
    public void findByStreetAsync(@Autowired AddressManagementService addressManagementService) {

        printTitle("Spring Data Ex.8; Async query results");

        addressManagementService.findByStreetAsync("Darwin Street");
    }

    @Test
    public void findByCityAsync(@Autowired AddressManagementService addressManagementService) {
        printTitle("Spring Data Ex.8; Async query results");

        addressManagementService.findByCityAsync("Kiev");
    }

}
