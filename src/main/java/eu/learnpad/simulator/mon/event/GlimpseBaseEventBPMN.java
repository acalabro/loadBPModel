package eu.learnpad.simulator.mon.event;

import eu.learnpad.sim.rest.event.AbstractEvent;
import eu.learnpad.simulator.mon.event.GlimpseBaseEventGeneric;


public class GlimpseBaseEventBPMN<T> extends GlimpseBaseEventGeneric<String> {

	private static final long serialVersionUID = 1L;
	public AbstractEvent event;

	public GlimpseBaseEventBPMN(String data, String probeID, Long timeStamp,
			String eventName, boolean isException, String extraDataField,
			AbstractEvent event) {

		super(data, probeID, timeStamp, eventName, isException, extraDataField);

		this.event = event;
	}

	public AbstractEvent getEvent() {
		return this.event;
	}

	public void setEvent(AbstractEvent event) {
		this.event = event;
	}
}
