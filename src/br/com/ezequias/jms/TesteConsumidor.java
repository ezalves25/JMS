package br.com.ezequias.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.cglib.proxy.Factory;

public class TesteConsumidor {
	public static void main(String[] args) throws Exception {
		
		
		InitialContext context=new InitialContext();
		
		ConnectionFactory factoy=(ConnectionFactory) context.lookup("ConnetionFactory");
		Connection connection=factoy.createConnection();
		
		
	}
		
}
