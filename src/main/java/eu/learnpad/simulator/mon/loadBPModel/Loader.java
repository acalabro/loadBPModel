package eu.learnpad.simulator.mon.loadBPModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import eu.learnpad.simulator.mon.example.MyGlimpseConsumer;
import eu.learnpad.simulator.mon.utils.Manager;


@Path("bpmnLoader")
public class Loader {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	new MyGlimpseConsumer(
				Manager.createConsumerSettingsPropertiesObject(
						"org.apache.activemq.jndi.ActiveMQInitialContextFactory", 
						"tcp://atlantis.isti.cnr.it:61616", 
						"system", 
						"manager", 
						"TopicCF", 
						"jms.serviceTopic", 
						false, "RestAPI"),
				readFile("/home/acalabro/workspace/loadBPModel/src/main/java/eu/learnpad/simulator/mon/example/bpmnToSendToTheMonitor.bpmn"),
				"1-2-3-4-5-6",
				"sessionID"+System.currentTimeMillis());	
    	
        return "Simulated BPMN and Learners ID sent";
    }
    
//    @POST
//    @Consumes(MediaType.APPLICATION_XML)
//    public String loadModel(String modelToLoad) {
//		new MyGlimpseConsumer(
//				Manager.createConsumerSettingsPropertiesObject(
//						"org.apache.activemq.jndi.ActiveMQInitialContextFactory", 
//						"tcp://atlantis.isti.cnr.it:61616", 
//						"system", 
//						"manager", 
//						"TopicCF", 
//						"jms.serviceTopic", 
//						false, "RestAPI"),
//				modelToLoad);		
//    	return "Model Sent";
//    }
    
    private String readFile(String fileName) {
		
    	StringBuilder sb;
    	String line; 
    	String everything = "";
    	BufferedReader br;
    	try {
    	br = new BufferedReader(new FileReader(fileName));
    	
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

	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String receiveJSON(JSONObject json) throws JSONException, IOException {
        
    	String theLearners = json.getString("LearnersID");
        
        new MyGlimpseConsumer(
				Manager.createConsumerSettingsPropertiesObject(
						"org.apache.activemq.jndi.ActiveMQInitialContextFactory", 
						"tcp://atlantis.isti.cnr.it:61616", 
						"system", 
						"manager", 
						"TopicCF", 
						"jms.serviceTopic", 
						false, "RestAPI"),
				json.getString("theBPMN"), theLearners);		
        
        return "Done";
    }
}
