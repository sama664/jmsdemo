package org.soumitra.poc.jmsdemo.listener;

import org.soumitra.poc.jmsdemo.model.Email;
import org.soumitra.poc.jmsdemo.model.Prodcut;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
//    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
//    public void receiveMessage(Email email) {
//        System.out.println("Received <" + email + ">");
//
//    }

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Prodcut prodcut) {
        System.out.println("Received <" + prodcut + ">");

    }

}
