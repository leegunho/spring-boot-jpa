package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

        @Override
        public void run(String... strings) throws Exception {
            // 데이터 추가
            Customer created = customerRepository.save(new Customer(null, "Lee" , "GeonHo"));
//            System.out.println(created + "생성 성공~!");
            // 데이터 표시
//            customerRepository.findAll().forEach(System.out::println);
            customerRepository.findAllOrderByName().forEach(System.out::println);
        }

    public static void main(String[] args) {
            SpringApplication.run(com.example.App.class, args);
        }

}
