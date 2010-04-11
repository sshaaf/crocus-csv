package net.sf.crocus.csv.record;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * </p>
 * 
 * <p>
 * </p>
 * 
 * @author not attributable
 * @email shaaf.m@gmail.com
 */
public class RecordManagerFactory {

	private static RecordManagerFactory rmFactory = null;

	private RecordManagerFactory() {
	}

	public static RecordManagerFactory getInstance() {
		if (rmFactory != null)
			return rmFactory;
		else
			return rmFactory = new RecordManagerFactory();
	}

	public CSVRecordManager getDefaultRecordManager() {
		return new CSVRecordManagerImpl();
	}

	/**
	 * 
	 * @return CSVRecord
	 */
	public CSVRecord getNewRecord() {
		return new CSVRecordImpl();
	}

	public CSVRecord getNewRecord(char DELIMINATOR) {
		return new CSVRecordImpl(DELIMINATOR);
	}
	
}
