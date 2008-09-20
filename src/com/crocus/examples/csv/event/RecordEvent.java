package com.crocus.examples.csv.event;

public class RecordEvent extends AbstractCSVEvent {

	public static final int RECORD_ADDED = 1;

	public static final int PRE_RECORD_ADDED = 2;

	public static final int POST_RECORD_ADDED = 3;

	private int recordKey = -1;

	private int eventId = -1;

	/**
	 * 
	 */
	private static final long serialVersionUID = -8572256608822175685L;

	public RecordEvent(Object source, int eventId) {
		super(source);
		this.setEventId(eventId);
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setRecordKey(int recordKey) {
		this.recordKey = recordKey;
	}

	public int getRecordKey() {
		return recordKey;
	}

	public String toString() {
		return this.source + "," + this.getEventId() + ","
				+ this.getRecordKey();

	}

}
