package org.soumitra.poc.jmsdemo.controller;

import org.soumitra.poc.jmsdemo.model.Prodcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.LongAccumulator;

@RestController
public class SendmessageController {

    @Autowired
    JmsTemplate jmsTemplate;

    LongAccumulator longAccumulator;
    @GetMapping("/publish")
    public String publish(){
        String result="Message Published";
        jmsTemplate.convertAndSend("mailbox", new Prodcut("myproduct", "1234"));

        return result;
    }
    @PostMapping("/sendmessage")
    public String SendMessage(@RequestBody Prodcut myproduct){
        jmsTemplate.convertAndSend("mailbox",myproduct);
        return "published through post";
    }
}
