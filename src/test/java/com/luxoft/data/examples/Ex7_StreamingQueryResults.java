package com.luxoft.data.examples;

import com.luxoft.data.examples.repositories.AddressManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ex7_StreamingQueryResults extends TestEnvironmentInit {

    @Test
    public void streamingQueryResults(@Autowired AddressManagementService addressManagementService) {

        printTitle("Spring Data Ex.7; Streaming query results");
        addressManagementService.findAllFromStream();
    }
}
