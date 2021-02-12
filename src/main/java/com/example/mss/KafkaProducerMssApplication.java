package com.example.mss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableFeignClients
public class KafkaProducerMssApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerMssApplication.class, args);
    }

}
