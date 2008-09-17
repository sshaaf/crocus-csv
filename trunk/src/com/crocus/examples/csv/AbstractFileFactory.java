package com.crocus.examples.csv;

import java.io.FileNotFoundException;

/**
 * <p>Title: </p>
 *
 * <p>Description: Abstract version of a FileFactory</p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */
public abstract class AbstractFileFactory {

    public AbstractFileFactory() {
    }

    public abstract CSVFile getFile(String fileName)  throws FileNotFoundException ;
}
