package com.example.mss;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Collection;

@SpringBootApplication
@EnableKafka
@EnableFeignClients
public class KafkaProducerMssApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerMssApplication.class, args);
    }
    @Bean
    CommandLineRunner start(RestOperationClient restOperationClient,KafkaTemplate<String,Operation> kafkaTemplate){
        final String topic="operation";
        return args -> {
            PagedModel<Operation> operations=restOperationClient.getAllOperations();
            operations.forEach((operation -> {
                System.out.println(operation);
                System.out.println("#########################");
                kafkaTemplate.send(topic,"key : "+operation.getNumero(),operation);
            }));
        };
    }
}
