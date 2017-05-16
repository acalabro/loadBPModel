package it.cnr.isti.labsedc.glimpse.example;

import it.cnr.isti.labsedc.glimpse.utils.Manager;

public class TestClass {

	public static void main (String[] args)  {
	
	new MyGlimpseConsumer(
			Manager.createConsumerSettingsPropertiesObject("org.apache.activemq.jndi.ActiveMQInitialContextFactory", 
					"tcp://atlantis.isti.cnr.it:61616", "system", "manager", 
					"TopicCF", "jms.serviceTopic", false,
					"ConsumerForSmartBuildingProbe"),
			Manager.ReadTextFromFile(args[0]));	
	}	
}