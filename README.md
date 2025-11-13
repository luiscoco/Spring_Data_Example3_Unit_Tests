# Spring_Data_Example3_Unit_Tests

## How to run the Unit Tests

We press the button for running all the tests in that file

<img width="1919" height="1020" alt="image" src="https://github.com/user-attachments/assets/0b8f0ce7-cc03-42e4-850a-bc830fcdb52a" />

We verify the results in the Tests Results tab

<img width="1919" height="1020" alt="image" src="https://github.com/user-attachments/assets/bc36e7b5-0649-4b8c-b09b-447f8d384586" />

## How to use the Codex AI Agent to implement the Tests in the Launcher.java file

For example if we would like to modify the Launcher.java file to implement the tests included in the Ex4_5_SpecialParameterHandling.java file, 

we open the **Codex** AI Agent and we type the following prompt:

```
I would like to modify the Launcher.java to implement the following tests in the Ex4_5_SpecialParameterHandling.java file
```

<img width="1919" height="1020" alt="image" src="https://github.com/user-attachments/assets/e5b58905-4440-4ecd-a373-7f3ea887e166" />

The AI Agent will modify the Launcher.java file and will create the following code:

```java
package com.luxoft.data.examples;

import com.luxoft.data.examples.model.Person;
import com.luxoft.data.examples.repositories.AddressRepository;
import com.luxoft.data.examples.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
public class Launcher implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public Launcher(PersonRepository personRepository,
                    AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Override
    public void run(String... args) {
        specialParameterHandlingSort();
        specialParameterHandlingPaging();
    }

    private void specialParameterHandlingSort() {
        printTitle("Spring Data Ex.4; Special parameter handling. Sorting");

        Sort sort = Sort.sort(Person.class)
                .by(Person::getName)
                .descending();

        personRepository
                .findByAge(21, sort)
                .forEach(Launcher::print);
    }

    private void specialParameterHandlingPaging() {
        printTitle("Spring Data Ex.5; Special parameter handling. Paging");

        addressRepository
                .findAllByCity("Kiev", PageRequest.of(1, 3, Sort.by("street")))
                .forEach(Launcher::print);
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void printTitle(String s) {
        System.out.println("\n==========================");
        System.out.println(s);
        System.out.println("==========================");
    }

}
```

Now we execute this command to run the application:

```
mvn spring-boot:run
```

Finally we verify the results:

<img width="1919" height="1021" alt="image" src="https://github.com/user-attachments/assets/9e477712-850b-4065-9ce6-950e53b543dd" />
