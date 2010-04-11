package net.sf.crocus.csv.record;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.crocus.csv.fields.CSVField;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: Implementation of the Record
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
public class CSVRecordImpl extends CSVRecord {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2244986568046868067L;

	private ArrayList<CSVField> fieldList = null;

	public CSVRecordImpl() {
		super();
		fieldList = new ArrayList<CSVField>();
	}

	public CSVRecordImpl(char DELIMINATOR) {
		super(DELIMINATOR);
		fieldList = new ArrayList<CSVField>();
	}

	
	/**
	 * 
	 * @param csvField
	 *            CSVField
	 */
	public void addField(CSVField csvField) {
		fieldList.add(csvField);
	}

	/**
	 * 
	 * @param csvField
	 *            CSVField
	 */
	public void removeField(CSVField csvField) {
		fieldList.remove(csvField);
	}

	/**
	 * 
	 * @param csvField
	 *            CSVField
	 * @return boolean
	 */
	public boolean contains(CSVField csvField) {
		return fieldList.contains(csvField);
	}

	/**
	 * 
	 * @return Object[]
	 */
	public Object[] getArrayOfRecords() {
		return fieldList.toArray();
	}

	/**
	 * 
	 * @return int
	 */
	public int getColumnCount() {
		return fieldList.size();
	}

	/**
	 * 
	 * @param columnIndex
	 *            int
	 * @return CSVField
	 */
	public CSVField getColumn(int columnIndex) {
		return fieldList.get(columnIndex);
	}

	/**
	 * 
	 * @param columnIndex
	 *            int
	 * @param csvField
	 *            CSVField
	 * @return CSVField
	 */
	public CSVField replaceColumn(int columnIndex, CSVField csvField) {
		fieldList.remove(columnIndex);
		fieldList.add(columnIndex, csvField);
		return fieldList.get(columnIndex);
	}

	/**
	 * 
	 * @param field
	 *            String
	 * @return boolean
	 */
	public boolean contains(String field) {
		for (CSVField a : fieldList)
			if (a.toString().equals(field))
				return true;
		return false;
	}

	
	public boolean containsInField(Pattern pattern){
		for (CSVField a : fieldList){
			Matcher matcher = pattern.matcher(a.toString());
			if (matcher.matches())
				return true;
		}
		return false;
	}
	
	public boolean containsInRecord(Pattern pattern){
		Matcher matcher = pattern.matcher(this.toString());
		if (matcher.matches())
			return true;
		
		return false;
	}
	
	public String toString() {
		return toString(DELIMINATOR);
	}

	public String toString(char deliminator) {
		StringBuilder builder = new StringBuilder();
		Iterator iterator = fieldList.iterator();
		while(iterator.hasNext()){
			builder.append(iterator.next());
			if(! iterator.hasNext())
				break;
			else builder.append(deliminator);
			
		}

		return builder.toString();
	}
	
	public Collection<CSVField> getFields(){
		return fieldList;
	}
}
