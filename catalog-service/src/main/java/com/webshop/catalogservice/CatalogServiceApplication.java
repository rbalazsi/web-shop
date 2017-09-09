package com.webshop.catalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.webshop.catalogservice.util.DummyDataGenerator;

@SpringBootApplication
public class CatalogServiceApplication implements CommandLineRunner {

    private static final String GEN_PARAM = "generate";

    @Autowired
    private DummyDataGenerator generator;

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0 && GEN_PARAM.equalsIgnoreCase(args[0])) {
            generator.generateAndSave();
        }
    }
}
