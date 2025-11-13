package com.luxoft.data.examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

@SpringBootTest
public class Ex11_Sorting extends TestEnvironmentInit {

    @Test
    public void findByAsArrayAndSortUsingDomainModelProperty1() {
        printTitle("Spring Data Ex.11; Sorting");

        Launcher.printTitle("Valid Sort expression pointing to property in domain model.");
        personRepository.findByAsArrayAndSort("I", Sort.by("name"))
                .stream()
                .map(arr -> arr[0])
                .forEach(Launcher::print);
    }

    @Test
    public void findByAsArrayAndSortUsingDomainModelProperty2() {
        printTitle("Spring Data Ex.11; Sorting");

        Launcher.printTitle("Valid Sort expression pointing to property in domain model.");
        personRepository.findAll(Sort.by("name", "age"))
                .stream()
                .forEach(Launcher::print);
    }

    @Test
    public void findByAsArrayAndSortUsingAliasedFunction() {
        printTitle("Spring Data Ex.11; Sorting");

        Launcher.printTitle("Valid Sort expression pointing to aliased function.");
        personRepository.findByAsArrayAndSort("I", Sort.by("fn_length"))
                .stream()
                .map(arr -> arr[0])
                .forEach(Launcher::print);

    }

    @Test
    public void findByAsArrayAndSortUsingUnsafe() {
        printTitle("Spring Data Ex.11; Sorting");

        Launcher.printTitle("Valid Sort containing explicitly unsafe Order.");
        personRepository.findByAsArrayAndSort("I", JpaSort.unsafe("LENGTH(p.name)"))
                .stream()
                .map(arr -> arr[0])
                .forEach(Launcher::print);
    }
}
