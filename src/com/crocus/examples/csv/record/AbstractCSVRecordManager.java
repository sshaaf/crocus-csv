package com.crocus.examples.csv.record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.crocus.examples.csv.event.RecordEvent;
import com.crocus.examples.csv.event.RecordListener;
import com.crocus.examples.csv.fields.CSVField;

/**
 * <p>Title: </p>
 *
 * <p>Description: An Abstract Record Manager</p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */
public abstract class AbstractCSVRecordManager implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -1785926313163654186L;
	
	private boolean allowListener = true;
	
	private boolean eventAsync = true;
	
	
	private ArrayList<RecordListener> recordListenerList= null;
	
	public AbstractCSVRecordManager() {
		recordListenerList = new ArrayList<RecordListener>();
    }
    	
	
	protected void sendEvent(CSVRecord csvRecord, int RECORD_EVENT_TYPE){
		RecordEvent recordEvent = new RecordEvent(this, RECORD_EVENT_TYPE);
		sendEvent(recordEvent);
		
	} 
	
	protected void sendEvent(RecordEvent recordEvent){
		for(RecordListener list: recordListenerList){
			list.eventPerformed(recordEvent);
		}
	} 
	
	
	/**
     *
     * @param record CSVRecord
     */
    public abstract void addRecord(CSVRecord record);
    /**
     *
     * @return Collection
     */
    public abstract Collection getRecordList();
    /**
     *
     * @param record CSVRecord
     */
    public abstract void containsRecord(CSVRecord record);
    /**
     *
     * @param columnIndex int
     * @return Object[]
     */
    public abstract Object[] getColumn(int columnIndex);

    public abstract CSVRecord getRow(int rowIndex);

    /**
     *
     * @return Collection
     */
    public abstract Collection getAllRecords();
    /**
     *
     * @return CSVRecord
     */
    public abstract CSVRecord getNewRecord();
    /**
     *
     * @return int
     */
    public abstract int getRowCount();
    /**
     *
     * @return int
     */
    public abstract int getColumnCount();
    /**
     *
     * @param rowIndex int
     * @param columnIndex int
     * @return Object
     */
    public abstract Object getValueAt(int rowIndex, int columnIndex);
    /**
     *
     * @param rowIndex int
     * @param columnIndex int
     * @return CSVField
     */
    public abstract CSVField getField(int rowIndex, int columnIndex);
    /**
     *
     * @param rowIndex int
     * @param columnIndex int
     * @return String
     */
    public abstract String getFieldType(int rowIndex, int columnIndex);
    
    public void addRecordListener(RecordListener recordListener){
    	this.recordListenerList.add(recordListener);
    }




	protected void setAllowListener(boolean allowListener) {
		this.allowListener = allowListener;
	}




	protected boolean isAllowListener() {
		return allowListener;
	}



	protected void setEventAsync(boolean eventAsync) {
		this.eventAsync = eventAsync;
	}



	protected boolean isEventAsync() {
		return eventAsync;
	}

}
