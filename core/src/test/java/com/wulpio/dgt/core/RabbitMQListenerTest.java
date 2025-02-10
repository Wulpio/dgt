package com.wulpio.dgt.core;

import com.wulpio.dgt.core.listener.model.TransactionMessage;
import org.junit.jupiter.api.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
public class RabbitMQListenerTest {

    private static RabbitMQContainer rabbitMQContainer;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @BeforeAll
    public static void setUpBeforeClass() {
        rabbitMQContainer = new RabbitMQContainer(DockerImageName.parse("rabbitmq:3.8-management"));
        rabbitMQContainer.start();
    }

    @BeforeEach
    public void setUp() {
        System.setProperty("spring.rabbitmq.host", rabbitMQContainer.getHost());
        System.setProperty("spring.rabbitmq.port", String.valueOf(rabbitMQContainer.getMappedPort(5672)));
        System.setProperty("spring.rabbitmq.username", "guest");
        System.setProperty("spring.rabbitmq.password", "guest");
    }

    @Disabled("due problem in github actions")
    @Test
    public void testRabbitListenerProcessesMessage() {
        TransactionMessage message = new TransactionMessage(1L, "basicTableFeeCalculator");

        rabbitTemplate.convertAndSend("QUEUE_DEMO_02", message);

        //TODO some assert after successful trigger
    }

    @AfterAll
    public static void tearDownAfterClass() {
        rabbitMQContainer.stop();
    }
}
