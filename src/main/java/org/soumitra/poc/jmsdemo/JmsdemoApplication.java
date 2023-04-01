package org.soumitra.poc.jmsdemo;

import org.soumitra.poc.jmsdemo.model.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;


@SpringBootApplication
@EnableJms
public class JmsdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(JmsdemoApplication.class, args);
		JmsTemplate jmsTemplate=context.getBean(JmsTemplate.class);
		System.out.println("Sending an email message.");
		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
	}


}
