package com.tu.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SenderApplication {

    /**
     * Създава обект от клас Queue, който е глобално достъпен
     * от приложението чрез @Autowired анотацията
     * */
    @Bean
    public Queue messageQueue() {
        return new Queue("faculty-number-queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }

}
