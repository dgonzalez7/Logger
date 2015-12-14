package logging.example1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.SimpleFormatter;

public class HelloWorld 
{
	private String theMessage;
	private static Logger theLogger = Logger.getLogger(HelloWorld.class.getName());

	public static void main(String[] args) 
	{		
		Handler[] handlers = Logger.getLogger( "" ).getHandlers();
		Handler handler = null;
		
		for (int index = 0; index < handlers.length; index++) 
		{
			handlers[index].setLevel( Level.FINE );
		}
		
		
		try 
		{
			handler = new FileHandler("test.log");
		} 
		catch (SecurityException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		handler.setFormatter(new SimpleFormatter());
		theLogger.addHandler(handler);
		theLogger.setLevel(Level.FINE);
		theLogger.setUseParentHandlers(false);
		
		// No logging
		// theLogger.setLevel(Level.OFF);
		
		HelloWorld hello = new HelloWorld("Hello world!");
		hello.sayHello();
	}

	public HelloWorld(String message) 
	{
		theMessage = message;
	}

	public void sayHello() 
	{
		theLogger.fine("Hello logging!");
		System.err.println(theMessage);
		System.out.println(theMessage);
		theLogger.fine("Message #2");
	}
}