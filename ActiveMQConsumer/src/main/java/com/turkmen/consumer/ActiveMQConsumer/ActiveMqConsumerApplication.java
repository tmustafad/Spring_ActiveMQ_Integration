package com.turkmen.consumer.ActiveMQConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;
import org.turkmen.person_schema.Person;

@SpringBootApplication
public class ActiveMqConsumerApplication {

	private static final Logger log=LoggerFactory.getLogger(ActiveMqConsumerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ActiveMqConsumerApplication.class, args);
	}
	
	
	@JmsListener(destination="${inbound.endpoint}")
	public void consumedMessageHandler(Person person) {
		log.info("Id :"+person.getId()+" Name: "+person.getName());
		
	}
}
