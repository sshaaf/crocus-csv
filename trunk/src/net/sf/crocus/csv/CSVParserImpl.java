package net.sf.crocus.csv;


import net.sf.crocus.csv.fields.StringField;
import net.sf.crocus.csv.record.CSVRecord;
import net.sf.crocus.csv.record.CSVRecordImpl;


public class CSVParserImpl extends CSVParser {


	public CSVParserImpl(char deliminator) {
		super(deliminator);
	}

	/**
	 * Execution Logic
	 */
	public CSVRecord parse(char[] charLine) {
		int counter = 0;
		
		CSVRecord csvRecord = new CSVRecordImpl();
		
		while (counter < charLine.length) {

			StringField csvField = null;
			
			if(charLine[counter] == CSVConstants.QUOTE){
				++counter; // Move 1 forward from the quote
				
				// Calculates index and creates a string
				int startIndex = counter; 
				int endIndex = getQuotedField(charLine, counter);  // e.g. "dfdfd"s,sfdf"dfd"
				csvField = new StringField(new String(charLine, startIndex, (endIndex-1)-startIndex));
				counter = endIndex;
				
			}
			else{
				StringBuilder sb = new StringBuilder(); // Init a builder for making the string for the csvField.
				while(charLine[counter] != getDeliminator()){ // from start to a deliminator-1 are field values

					sb.append(charLine[counter]);
					++counter;
				
					if(counter == charLine.length)
						break;
				
				}
				csvField = new StringField(sb.toString());
			}			

			csvRecord.addField(csvField);
			counter++; // increment to avoid starting from comma again.
			
		}
		return csvRecord;
	}

	private int getQuotedField(char[] charLine, int counter){
		while(counter < charLine.length){
			
			if(counter == charLine.length-1){
				++counter;
				break;
			}
			
			if(charLine[counter] == CSVConstants.QUOTE && charLine[counter+1] == getDeliminator()){
				++counter;
				break;
			}
			 
			else 
				++counter;
		}
		
		return counter;
	}

}
