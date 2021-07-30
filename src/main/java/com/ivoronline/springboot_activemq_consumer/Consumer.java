package com.ivoronline.springboot_activemq_consumer;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class Consumer implements MessageListener {

    @Override
    @JmsListener(destination = "Topic1")
    public void onMessage(Message message) {
      ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
      try {
        System.out.println("Received Message: "+ textMessage.getText());
      } catch (JMSException e) {
        e.printStackTrace();
      }
    }

}