package com.crocus.examples.csv.record;

import java.util.Collection;
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
public abstract class AbstractCSVRecordManager {
    public AbstractCSVRecordManager() {
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

}
