package br.com.rabbitmq.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rabbitmq.service.IMessageService;

@Service("messageService")
public class MessageService implements IMessageService {
	
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void send(final String queue, final String message) {
		try {
			rabbitTemplate.convertAndSend(queue, message);
			
            System.out.println(" [x] Sent '" + message  + "'");
            
        } catch (Exception io) {
            System.out.println("Exception");
            io.printStackTrace();
        }		
	
	}
	
}
