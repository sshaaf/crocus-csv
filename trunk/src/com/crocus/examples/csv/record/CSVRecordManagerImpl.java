package com.crocus.examples.csv.record;

import java.util.Collection;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.crocus.examples.csv.event.RecordEvent;
import com.crocus.examples.csv.fields.CSVField;
import com.crocus.examples.csv.fields.FieldFactory;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: RecordManager Impl
 * </p>
 * 
 * <p>
 * Copyright:
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */

public class CSVRecordManagerImpl extends CSVRecordManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6048023925794149445L;

	private ArrayList<CSVRecord> recordList;

	private int ROW_COUNT = 0;

	private int COLUMN_COUNT = 0;

	private boolean isMultipleFileSupported = false;
	
	private boolean isFirstRowNames = false;

	// private static CSVRecordManagerImpl manager;

	protected CSVRecordManagerImpl() {
		recordList = new ArrayList<CSVRecord>();
	}

	/**
	 * Singelton
	 * 
	 * @return CSVRecordManagerImpl
	 */
	/*
	 * public static CSVRecordManagerImpl getInstance() { if (manager != null)
	 * return manager; else return manager = new CSVRecordManagerImpl(); }
	 */
	/**
	 * 
	 * @param record
	 *            CSVRecord
	 */
	public void addRecord(CSVRecord record) {

		RecordEvent recordEvent = new RecordEvent(this,
				RecordEvent.PRE_RECORD_ADDED);

		sendEvent(recordEvent);

		recordList.add(record);
		if (record.getColumnCount() > COLUMN_COUNT)
			COLUMN_COUNT = record.getColumnCount();
		ROW_COUNT++;

		recordEvent.setRecordKey(ROW_COUNT);
		recordEvent.setEventId(RecordEvent.RECORD_ADDED);
		sendEvent(recordEvent);

	}

	/**
	 * 
	 * @return Collection
	 */
	public Collection<CSVRecord> getRecordList() {
		return recordList;
	}

	/**
	 * 
	 * @param record
	 *            CSVRecord
	 */
	public void removeRecord(CSVRecord record) {
		recordList.remove(record);
		ROW_COUNT = recordList.size();
	}

	/**
	 * 
	 * @param record
	 *            CSVRecord
	 */
	public void containsRecord(CSVRecord record) {
		recordList.contains(record);
	}

	/**
	 * 
	 * @param columnIndex int
	 * Unimplemented
	 * @return Object[]
	 */
	private Object[] getColumn(int columnIndex) {
		
		return null;
	}

	public CSVRecord getRow(int rowIndex) {
		return recordList.get(rowIndex);
	}

	/**
	 * 
	 * @return Collection
	 */
	public Collection<CSVRecord> getAllRecords() {
		return recordList;
	}

	
	/**
	 * 
	 * Get ColumnNames
	 * If firstRow is not columns returns null
	 * @return CSVRecord
	 */
	public CSVRecord getColumnNames(){
		if(isFirstRowNames)
			return recordList.get(0);
		else 
			return null;
	}
	

	public boolean isFirstRowNames() {
		return isFirstRowNames;
	}

	public void setFirstRowNames(boolean isFirstRowNames) {
		this.isFirstRowNames = isFirstRowNames;
	}
	
	public Collection<CSVRecord> getRecordsByField(Pattern pattern){
		
		ArrayList<CSVRecord> searchResults = new ArrayList<CSVRecord>();
		for(CSVRecord record: recordList)
			if(record.containsInField(pattern))
				searchResults.add(record);
		
		return searchResults;
	}
	
	public Collection<CSVRecord> getRecords(Pattern pattern){
		ArrayList<CSVRecord> searchResults = new ArrayList<CSVRecord>();
		for(CSVRecord record: recordList)
			if(record.containsInRecord(pattern))
				searchResults.add(record);
		
		return searchResults;
	}
	

	public String getXML(Collection<CSVRecord> recordsList){
		if(isFirstRowNames){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<result>");
		CSVRecord columnNames = getColumnNames();
		
		for(CSVRecord record: recordsList){
			buffer.append("<row>");
			Collection<CSVField> fields = record.getFields();
			int i = 0;
			for(CSVField field: fields){
				buffer.append("<"+columnNames.getColumn(i)+">");
				buffer.append(field.getValue());
				buffer.append("</"+columnNames.getColumn(i)+">");
				i++;
			}
			buffer.append("</row>");
		}
		buffer.append("</result>");
		
		return buffer.toString();
		}
		return null;
	}
	
	
	public String getJSON(Collection<CSVRecord> recordsList){
		if(isFirstRowNames){
		StringBuffer buffer = new StringBuffer();
		buffer.append("{\"result\":");
		CSVRecord columnNames = getColumnNames();
		
		for(CSVRecord record: recordsList){
			buffer.append("{\"row\":");
			buffer.append("{");
			Collection<CSVField> fields = record.getFields();
			int i = 0;
			for(CSVField field: fields){
				buffer.append("\""+columnNames.getColumn(i)+"\":");
				buffer.append("\""+field.getValue()+"\"");
				if(i < fields.size()-1)
					buffer.append(",");
				i++;
			}
			buffer.append("}");
			buffer.append("}");
		}
		buffer.append("}");
		
		return buffer.toString();
		}
		return null;
	}
	
	/**
	 * 
	 * @return CSVRecord
	 */
	public CSVRecord getNewRecord() {
		return new CSVRecordImpl();
	}

	/**
	 * 
	 * @return int
	 */
	public int getRowCount() {
		return ROW_COUNT;
	}

	/**
	 * 
	 * @return int
	 */
	public int getColumnCount() {
		return COLUMN_COUNT;
	}

	/**
	 * 
	 * @param rowIndex
	 *            int
	 * @param columnIndex
	 *            int
	 * @return Object
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		CSVRecord csvRecord = recordList.get(rowIndex);
		if (columnIndex >= csvRecord.getColumnCount())
			return "";
		else
			return (csvRecord.getColumn(columnIndex)).getValue();
	}

	/**
	 * 
	 * @param rowIndex
	 *            int
	 * @param columnIndex
	 *            int
	 * @return CSVField
	 */
	public CSVField getField(int rowIndex, int columnIndex) {
		CSVRecord csvRecord = recordList.get(rowIndex);
		return FieldFactory.getInstance().getType(
				(csvRecord.getColumn(columnIndex)).getType(),
				String.valueOf((csvRecord.getColumn(columnIndex)).getValue()));
	}

	/**
	 * 
	 * @param rowIndex
	 *            int
	 * @param columnIndex
	 *            int
	 * @param FIELD
	 *            int
	 * @return CSVField
	 */
	public CSVField getConvertField(int rowIndex, int columnIndex, int FIELD) {
		CSVRecord csvRecord = recordList.get(rowIndex);
		CSVField csvField = FieldFactory.getInstance().getType(FIELD,
				String.valueOf((csvRecord.getColumn(columnIndex)).getValue()));
		if (csvField != null)
			return csvRecord.replaceColumn(columnIndex, csvField);
		else
			return csvRecord.getColumn(columnIndex);
	}

	/**
	 * 
	 * @param rowIndex
	 *            int
	 * @param columnIndex
	 *            int
	 * @return String
	 */
	public String getFieldType(int rowIndex, int columnIndex) {
		CSVRecord csvRecord = recordList.get(rowIndex);
		return FieldFactory.getInstance().getType(
				(csvRecord.getColumn(columnIndex)).getType());
	}

	/**
	 * @return the isMultipleFileSupported
	 */
	public boolean isMultipleFileSupported() {
		return isMultipleFileSupported;
	}

	/**
	 * @param isMultipleFileSupported
	 *            the isMultipleFileSupported to set
	 */
	public void setMultipleFileSupported(boolean isMultipleFileSupported) {
		this.isMultipleFileSupported = isMultipleFileSupported;
	}

}
