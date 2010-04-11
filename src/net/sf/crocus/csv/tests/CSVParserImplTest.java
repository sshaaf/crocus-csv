package net.sf.crocus.csv.tests;

import net.sf.crocus.csv.CSVConstants;
import net.sf.crocus.csv.CSVParserImpl;
import net.sf.crocus.csv.record.CSVRecord;
import junit.framework.TestCase;

public class CSVParserImplTest extends TestCase {

	public void testSimpleParse() {
		CSVParserImpl impl = new CSVParserImpl(CSVConstants.COMMA);
		CSVRecord record = impl.parse("ABC,BCD, DEF, FFG".toCharArray());
		if(!record.toString().equals("ABC,BCD, DEF, FFG"))
			fail("Unexpected output");
		}

	public void testQuoteParse() {
		CSVParserImpl impl = new CSVParserImpl(CSVConstants.COMMA);
		CSVRecord record = impl.parse("\"ABC\",BCD, DEF, FFG".toCharArray());
		if(!record.toString().equals("ABC,BCD, DEF, FFG"))
			fail("Unexpected output");
		}
	
	public void testCommaInQuoteParse() {
		CSVParserImpl impl = new CSVParserImpl(CSVConstants.COMMA);
		CSVRecord record = impl.parse("\"ABCD,FDFDFD\",BCD, DEF, FFG".toCharArray());
		if(!record.toString().equals("ABCD,FDFDFD,BCD, DEF, FFG") && record.getFields().size() != 4)
			fail("Unexpected output");
		}
	
	public void testQuoteInQuoteParse() {
		CSVParserImpl impl = new CSVParserImpl(CSVConstants.COMMA);
		CSVRecord record = impl.parse("\"ABC\"DFDFD\"\",BCD, DEF, FFG".toCharArray());
		if(!record.toString().equals("ABC\"DFDFD\",BCD, DEF, FFG"))
			fail("Unexpected output");
		}
	
	public void testQuotedColumnsParse() {
		String testString = "\"LKnummer\",\"Elnummer\",\"EANnummer\",\"Korttxt\",\"Vejledningsnr\",\"Version\",\"Gammel\",\"Filnavn\",\"Sapkorttxt\",\"Online\",\"Side\",\"Aar\",\"elraad\",\"elraad1\",\"Sprog\"";
		CSVParserImpl impl = new CSVParserImpl(CSVConstants.COMMA);
		CSVRecord record = impl.parse(testString.toCharArray());
		if(!record.toString().equals("LKnummer,Elnummer,EANnummer,Korttxt,Vejledningsnr,Version,Gammel,Filnavn,Sapkorttxt,Online,Side,Aar,elraad,elraad1,Sprog"))
			fail("Unexpected output");
		}
	
	public void testQuotedColumns(){
		
		
	}
	
}
