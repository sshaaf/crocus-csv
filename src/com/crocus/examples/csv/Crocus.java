package com.crocus.examples.csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.crocus.examples.csv.record.CSVRecordManager;

/**
 * <p>Title: </p>
 *
 * <p>Description: The main class for the system Launch</p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */
public class Crocus {

    private CSVFile csvFile = null;

    private CSVRecordManager recordManager = null;

    /**
     *
     * @throws IOException
     */
    public Crocus(String fileName, char deliminator) throws FileNotFoundException {
        csvFile = new CSVFileImpl(fileName, deliminator);
    }

    /**
     *
     * @param fileName String
     * @throws FileNotFoundException
     */
    public Crocus(String fileName) throws FileNotFoundException {
        csvFile = new CSVFileImpl(fileName, CSVConstants.COMMA);
    }

    /**
     *
     * @param fileName String
     * @param deliminator char
     * @param csvRecordManager CSVRecordManager
     * @throws FileNotFoundException
     */
    public Crocus(String fileName, char deliminator, CSVRecordManager csvRecordManager) throws FileNotFoundException {
        csvFile = new CSVFileImpl(fileName, deliminator, csvRecordManager);
    }

    /**
     *
     * @return CSVRecordManager
     * @throws IOException
     * @throws FileNotFoundException
     */
    public CSVRecordManager read() throws IOException,FileNotFoundException {
        AbstractCSVReader reader = null;
            reader = new CSVReaderImpl(csvFile, csvFile.getDeliminator());
            while (reader.readNextLine())
            {
            }
        return csvFile.getCSVRecordManager();
    }

    public void write(CSVFile newCsvFile) throws FileNotFoundException, IOException {
        newCsvFile.openFile();
        newCsvFile.write();
    }

    /**
     *
     * @return CSVRecordManager
     */
    public CSVRecordManager getRecordManager(){
        return csvFile.getCSVRecordManager();
    }

    public CSVFile getCSVFile(){
        return this.csvFile;
    }

    public static void main(String args[]) throws IOException {
        Crocus c = new Crocus(args[0],CSVConstants.TAB);
        System.out.println("Reading");
        c.read();
        System.out.println("Writing");
        c.write(new CSVFileImpl("/home/wiz/ocitrace_testData/tempFileTest.csv",CSVConstants.SEMI_COLON,c.csvFile.getCSVRecordManager()));
    }

}
