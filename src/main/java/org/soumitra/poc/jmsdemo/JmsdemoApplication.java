package org.soumitra.poc.jmsdemo;

import org.soumitra.poc.jmsdemo.model.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


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
