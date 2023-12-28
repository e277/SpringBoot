package com.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Ezra", "Muir", "Chief Executive Officer")));
            log.info("Preloading " + employeeRepository.save(new Employee("John", "Doe", "Chief Financial Officer")));
            log.info("Preloading " + employeeRepository.save(new Employee("Vanessa", "Renae", "Chief Operating Officer")));
            log.info("Preloading " + employeeRepository.save(new Employee("Jane", "Doe", "Chief Technology Officer")));
            log.info("Preloading " + employeeRepository.save(new Employee("Michelle", "Obama", "President")));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
            orderRepository.save(new Order("iPad", Status.COMPLETED));
            orderRepository.save(new Order("iMac", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

        };
    }
}
