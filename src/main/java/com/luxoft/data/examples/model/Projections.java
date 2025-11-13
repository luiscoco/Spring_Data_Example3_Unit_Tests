package com.luxoft.data.examples.model;

import org.springframework.beans.factory.annotation.Value;

public class Projections {


    public interface PersonSummary {

        String getId();

        AddressSummary getAddress();

        @Value("#{target.name} #{target.age} years old")
        String getInfo();

        interface AddressSummary {
            String getCity();
        }

    }

    public static class NameOnly {

        private final String name;

        public NameOnly(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "NameOnly{" +
                    "name='" + name + '\'' +
                    '}';
        }

    }
}
