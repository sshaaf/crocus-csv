package com.crocus.examples.csv.record;

import java.util.Collection;
import java.util.ArrayList;

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
	 * @param columnIndex
	 *            int
	 * @return Object[]
	 */
	public Object[] getColumn(int columnIndex) {
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