package com.tu.sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
/**
 * Създава се инстанция на класа, която регулярно изпраща факултетни номера
 * към опашката и чака като отговор име на студентс
 */
@Component
public class Sender {
    /**
     * Обект за работа с RabbitMQ опашки
     */
    private final RabbitTemplate rabbitTemplate;
    /**
     * Обект, репрезентиращ опашка
     */
    private final Queue queue;
    private final Logger logger;

    @Autowired
    public Sender(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.logger = LoggerFactory.getLogger(Sender.class);
    }
    /**
     * Изпраща съобщения през интервал от 5 секунди
     */
    @Scheduled(fixedDelay = 5000)
    public void sendMessage() {
        String facultyNumber = getRandomFacultyNumber();
        String studentName = (String) this.rabbitTemplate.convertSendAndReceive(queue.getName(), facultyNumber);
        logger.info(facultyNumber + ": " + studentName);
    }
    /**
     * Метод за генериране на факултетен номер
     */
    private String getRandomFacultyNumber() {
        String prefix = "121217";
        String zeros = "";

        int lastDigits = new Random().nextInt(30) + 1;
        String suffix = String.valueOf(lastDigits);

        if (suffix.length() == 1)
            zeros = "00";
        else if (suffix.length() == 2)
            zeros = "0";

        return prefix + zeros + suffix;
    }
}
