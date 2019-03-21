package br.com.ezequias.jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.Message;
import org.springframework.cglib.proxy.Factory;

public class TesteConsumidor {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		//================================inicialização ===============================
		InitialContext context=new InitialContext();
		
		ConnectionFactory factoy=(ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection=factoy.createConnection();
		connection.start();				
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//============================================================================
		
		Destination fila=(Destination) context.lookup("financeiro");
		MessageConsumer consumer= session.createConsumer(fila);
		
		Message message=(Message) consumer.receive();
		
		System.out.println("recebendo mensagem"+message);
		
		new Scanner(System.in).nextLine();
		
		session.close();
		connection.close();
		context.close();
	}
		
}
