package eu.learnpad.simulator.mon.tester;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.core.util.Base64;

public class ClientRestSender {

	    public static void main(String[] args) throws JSONException, IOException 
	    {
	    	ClientRestSender my_client = new ClientRestSender();
	        File file_upload = new File("/home/acalabro/workspace/loadBPModel/src/main/java/eu/learnpad/simulator/mon/tester/subProcess_v3.bpmn");
	        my_client.sendFileJSON(file_upload);
	    }


	    private void sendFileJSON(File file_upload) throws JSONException, IOException{

	        ClientConfig config = new DefaultClientConfig();
	        Client client = Client.create(config);
	        client.addFilter(new LoggingFilter());
	        WebResource service = client.resource("http://localhost:8080/loadBPModel/webapi/bpmnLoader");
	        JSONObject data_file = new JSONObject();
	        data_file.put("LearnersID", "asd" );
	        data_file.put("theBPMN", convertFileToString(file_upload));

	        ClientResponse client_response = service.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, data_file);

	        System.out.println("Status: "+client_response.getStatus());

	        client.destroy();

	    }


	    //Convert my file to a Base64 String
	    private String convertFileToString(File file) throws IOException{
	        byte[] bytes = Files.readAllBytes(file.toPath());   
	        return new String(Base64.encode(bytes));
	    }

	}
