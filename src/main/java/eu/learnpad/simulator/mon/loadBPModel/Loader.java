package eu.learnpad.simulator.mon.loadBPModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    	
        return "Got it!";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public String loadModel(String modelToLoad) {
		new MyGlimpseConsumer(
				Manager.createConsumerSettingsPropertiesObject(
						"org.apache.activemq.jndi.ActiveMQInitialContextFactory", 
						"tcp://atlantis.isti.cnr.it:61616", 
						"system", 
						"manager", 
						"TopicCF", 
						"jms.serviceTopic", 
						false, "RestAPI"),
				modelToLoad);		
    	return "Model Sent";
    }
}
