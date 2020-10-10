package com.codingproject;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Consumer {

	private static final String QUEUE_FACTORY= "amexQueueFactory";
	private static final String QUEUE_NAME="amexQueue";

	public static void Consume() {
		try {
			InitialContext context = new InitialContext();
		
			QueueConnectionFactory factory =(QueueConnectionFactory)context.lookup(QUEUE_FACTORY);  
			QueueConnection conn = factory.createQueueConnection();
			conn.start();  

			QueueSession session=conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
			Queue queue=(Queue)context.lookup(QUEUE_NAME);  
			QueueReceiver receiver = session.createReceiver(queue);
			receiver.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					// TODO Auto-generated method stub
					try{  
				        TextMessage msg=(TextMessage)message;  
				        System.out.println(msg.getText());  
					}
					catch(JMSException e){
						e.printStackTrace();
					}  
				}  
			});

			while(true){                  
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}  
		}
		catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}  
	}
	
}
