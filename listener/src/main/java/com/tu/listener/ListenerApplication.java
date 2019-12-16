package com.tu.listener;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ListenerApplication {

    /**
     * Създава обект от клас Queue, който е глобално достъпен
     * от приложението чрез @Autowired анотацията
     */
    @Bean
    public Queue messageQueue() {
        return new Queue("faculty-number-queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }

}
