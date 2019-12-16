package com.tu.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Инстанцията на този клас чете съобщения от опашката
 */
@RabbitListener(queues = "faculty-number-queue")
@Component
public class FacultyNumberReceiver {

    /**
     * Метод за обработка на съобщения
     */
    @RabbitHandler
    public String receive(String facultyNumber) {
        return StudentData.getNameByFacNumber(facultyNumber);
    }
}
