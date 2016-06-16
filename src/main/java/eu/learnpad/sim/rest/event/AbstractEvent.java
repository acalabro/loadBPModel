package eu.learnpad.sim.rest.event;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Tom Jorquera - Linagora
 *
 */
public abstract class AbstractEvent implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4734413104214101930L;

	public EventType type;
	public Long timestamp;
	public String simulationsessionid;
	public List<String> involvedusers;
	public String modelsetid;
	public Map<String, Object> simulationSessionData;

	public AbstractEvent() {
		super();
	}

	public AbstractEvent(EventType type, Long timeStamp, String simulationsessionid, List<String> involvedusers,
			String modelsetid, Map<String, Object> simulationSessionData) {
		super();
		this.type = type;
		this.timestamp = timeStamp;
		this.simulationsessionid = simulationsessionid;
		this.involvedusers = involvedusers;
		this.modelsetid = modelsetid;
		this.simulationSessionData = simulationSessionData;
	}

	@Override
	public String toString() {
		return "Event: " + "type=" + type + " timestamp=" + timestamp + " simulationsessionid=" + simulationsessionid
				+ " involvedusers=" + involvedusers + " modelsetid=" + modelsetid + " simulationSessionData="
				+ simulationSessionData;
	}
}