package qwe;



import java.util.Properties;

import hlw.HelloUserRemote;


//import javax.ejb.EJB;
import javax.naming.InitialContext;


public class Client {
	
	//depending injection - не работает

	
	private static  HelloUserRemote hello;
	
	public static void main(String [] args) throws Exception{
		
		
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs","org.jboss.naming : org.jnp.interfaces");
		properties.put("java.naming.provider.url","localhost:1099");
	    InitialContext ctx = new InitialContext(properties);
		hello = (HelloUserRemote) ctx.lookup("HelloUserBean/remote");
		
		
		String res=hello.sayHello("Polling");
		System.out.println(res);
		
	} 
}
