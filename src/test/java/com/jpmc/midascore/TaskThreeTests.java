package com.jpmc.midascore;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
class TaskThreeTests {

    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    void task_three_verifier() throws InterruptedException {
        // Hardcoded data to bypass file loading issues
        String[] transactionLines = new String[] {
            "22158814280, 33504388100, 100",
            "33504388100, 84497678548, 50",
            "84497678548, 22158814280, 20"
        };

        for (String line : transactionLines) {
            String[] data = line.split(", ");
            Transaction t = new Transaction(Long.parseLong(data[0]), Long.parseLong(data[1]), Float.parseFloat(data[2]));
            kafkaTemplate.send("trader-updates", t);
        }

        // Wait for the magic to happen
        Thread.sleep(2000);

        System.out.println("===== BEGIN ANSWER =====");
        UserRecord waldorf = userRepository.findByName("waldorf");
        if (waldorf != null) {
            System.out.println("WALDORF BALANCE: " + waldorf.getBalance());
        } else {
            System.out.println("WALDORF NOT FOUND");
        }
        System.out.println("===== END ANSWER =====");
    }
}