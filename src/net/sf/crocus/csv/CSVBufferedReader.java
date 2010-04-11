package net.sf.crocus.csv;

/**
 * <p>Title: </p>
 *
 * <p>Description: an Abstract version of the Reader </p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public abstract class CSVBufferedReader extends BufferedReader implements CSVReader{

	protected StringBuffer currentLine = null;

	private CSVParser parser = null;
	
	private Reader reader = null;
	
	public CSVBufferedReader(Reader reader) throws FileNotFoundException{
		this(reader, null);
	}
	
	public CSVBufferedReader(Reader reader, CSVParser parser) throws FileNotFoundException{
		super(reader);
		this.setParser(parser);
	}

	
	protected StringBuffer getCurrentLine() {
		return currentLine;
	}
	
	public abstract boolean readNextLine() throws IOException;
	
	public void setParser(CSVParser parser) {
		this.parser = parser;
	}

	public CSVParser getParser() {
		return parser;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Reader getReader() {
		return reader;
	}
	
}
