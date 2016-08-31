package eu.learnpad.simulator.mon.utils;

/**
 * This class provides print function for debug
 * 
 * @author Antonello Calabr&ograve;
 * @version 3.2 
 *
 */
import org.apache.commons.net.ntp.TimeStamp;

/**
 * This class provides print function for debug
 * 
 * @author Antonello Calabr&ograve;
 *
 */
public class DebugMessages {

	public static int lastMessageLength = 0;	
	/**
	 * Print the string "className : message " without break line.
	 * Can be used with method {@link #ok()}
	 * 
	 * @param callerClass the name of the class that is calling method
	 * @param messageToPrint the message to print
	 */
	
	public static void print(TimeStamp now, String callerClass, String messageToPrint)
	{
		String message = now.getDate().toString() + " - " +  callerClass + ": " + messageToPrint;
		System.err.print(message);
		lastMessageLength = message.length();
	}
	/**
	 * Print the string "className : message " with break line.
	 * Can be used with method {@link #ok()}
	 * 
	 * @param callerClass the name of the class that is calling method
	 * @param messageToPrint the message to print
	 */
	public static void println(TimeStamp now, String callerClass, String messageToPrint)
	{
		String message = now.getDate().toString() + " - " +  callerClass + ": " + messageToPrint;
		System.err.println(message);
	}
	/**
	 * Print the OK text
	 */
	public static void ok()
	{
		int tab = 15 - (lastMessageLength / 8);
		String add="";
		for(int i = 0; i< tab;i++) {
			add +="\t"; 
		}
		System.err.println(add + "[ OK ]");
	}
	/**
	 * 
	 * Print a line <br />
	 */
	public static void line() {
		System.err.println("------------------------------------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Print asterisks
	 */
	public static void asterisks() {
		System.err.println("******************************************************************************************************************************");
	}
}
