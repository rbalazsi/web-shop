package com.webshop.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.webshop.searchservice.util.DummyDataGenerator;

@SpringBootApplication
public class SearchServiceApplication implements CommandLineRunner {

    private static final String GEN_PARAM = "generate";

    @Autowired
    private DummyDataGenerator generator;

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0 && GEN_PARAM.equalsIgnoreCase(args[0])) {
            generator.generateAndSave();
        }
    }
}