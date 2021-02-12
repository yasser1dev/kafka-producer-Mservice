package com.example.mss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String,Operation> kafkaTemplate;
    @Autowired
    private RestOperationClient restOperationClient;
    private final String topic="operation";

    public KafkaProducer(KafkaTemplate<String, Operation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

    }

    @Bean
    public void produceOperations(){
        Collection<Operation> operations=restOperationClient.getAllOperations();
        operations.forEach((operation -> {
            System.out.println(operation);
            System.out.println("#########################");
            kafkaTemplate.send(topic,"key : "+operation.getNumero(),operation);
        }));
    }

}
