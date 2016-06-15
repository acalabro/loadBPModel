package eu.learnpad.simulator.mon.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eu.learnpad.simulator.mon.utils.Manager;

public class TestClass {

	public static void main (String[] args)  {
	
		List<String> learnersInvolved = new ArrayList<>();
		learnersInvolved.add("1");
		learnersInvolved.add("2");
		learnersInvolved.add("3");
		learnersInvolved.add("4");
		learnersInvolved.add("5");
		learnersInvolved.add("6");
		
	new MyGlimpseConsumer(
			Manager.createConsumerSettingsPropertiesObject(
					"org.apache.activemq.jndi.ActiveMQInitialContextFactory", 
					"tcp://localhost:61616", //the activeMQ instance is run by the monitoring component 
					"system", 
					"manager", 
					"TopicCF", 
					"jms.serviceTopic", 
					false,
					"SimulationComponent"), //sender name
			readFile("bpmnToSendToTheMonitor.bpmn"), //the bpmn file to send as payload
			learnersInvolved, //IDs of the learners involved within the process
			"sessionID"+System.currentTimeMillis(), //learning session id
			"a23748293649" //the ID of the bpmn
			);	
	}	
	
	
	public static String readFile(String fileName) {
		
    	StringBuilder sb;
    	String line; 
    	String everything = "";
    	BufferedReader br;
    	try {
    	br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + fileName));
    	
    	    sb = new StringBuilder();
    	    line = br.readLine();

    	    while (line != null) {
    	        sb.append(line);
    	        sb.append(System.lineSeparator());
    	        line = br.readLine();
    	    }
    	    everything = sb.toString();
    	    br.close();
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return everything;
	}
}