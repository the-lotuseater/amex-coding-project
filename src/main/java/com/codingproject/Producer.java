package com.codingproject;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.messaging.QueueConnectionFactory;

public class Producer {
	 private static Logger logger = LoggerFactory.getLogger(Producer.class);

	private static final String QUEUE_FACTORY= "amexQueueFactory";
	private static final String QUEUE_NAME="amexQueue";
	

	public static void produce (List<?> args){
		logger.trace("Creating session to send message to queue with details"+args.toString());
		String total = args.get(0).toString();
		String order = (String) args.get(1);
		try {
			InitialContext context = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup(QUEUE_FACTORY);
			QueueConnection conn = factory.createQueueConnection();
			conn.start();
			
            QueueSession session=conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
            Queue queue=(Queue)context.lookup("QUEUE_NAME");  
            MessageProducer producer = session.createProducer(queue);

            StringBuilder sb = new StringBuilder();
            sb.append("Thank you for shopping at Abhishek's Fruit store!");
            sb.append("\nYour order of");
            sb.append(order);
            sb.append(" totalling: $");
            sb.append(total);
            sb.append(" will arive in 5-7 business days.");

            TextMessage message = session.createTextMessage(sb.toString());
            producer.send(message);
            logger.trace("Producer message successfully");
            return;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.trace("Error producing message.");
		return;
	}
	
}
