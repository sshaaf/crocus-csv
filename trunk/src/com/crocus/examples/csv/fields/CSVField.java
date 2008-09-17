package com.crocus.examples.csv.fields;

/**
 * <p>Title: </p>
 *
 * <p>Description: A generic CSVField</p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */
public interface CSVField {
    /**
     * get the type of the value
     * @return int
     */
    public int getType();

    /**
     * get the current Value
     * @return Object
     */
    public Object getValue();
}
