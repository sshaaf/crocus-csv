package net.sf.crocus.csv;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import net.sf.crocus.csv.record.AbstractCSVRecordManager;

public class CSVBufferedReaderImpl extends CSVBufferedReader {

	private AbstractCSVRecordManager manager = null;
	
	public CSVBufferedReaderImpl(Reader reader) throws FileNotFoundException{
		this(reader, new CSVParserImpl(CSVConstants.COMMA));
	}
	
	public CSVBufferedReaderImpl(Reader reader, CSVParser parser) throws FileNotFoundException{
		super(reader, parser);
	}
	
	public CSVBufferedReaderImpl(Reader reader, CSVParser parser, AbstractCSVRecordManager manager) throws FileNotFoundException{
		super(reader, parser);
		this.manager = manager;
	}
	
	
	@Override
	public String readLine() throws IOException {
		return super.readLine();
	}
	
	public boolean readNextLine() throws IOException {
		String curLine = null;
		while((curLine = readLine()) != null){
			manager.addRecord(getParser().parse(curLine.toCharArray()));
		}
		return currentLine != null;
	}
}
