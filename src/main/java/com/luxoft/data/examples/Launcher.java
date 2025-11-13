package com.luxoft.data.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
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
