package com.crocus.examples.csv.fields;

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

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateField extends Date implements CSVField{

    private Date date;

    private DateFormat dateFormat;// = new SimpleDateFormat("MM/dd/yyyy");
    /**
     *
     * @param date String
     */
    public DateField(String date) throws ParseException {
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            this.date = (Date) dateFormat.parse(date);
    }
    /**
     *
     * @return int
     */
    public int getType() {
        return FieldConstants.SIMPLE_DATE;
    }
    /**
     *
     * @return Object
     */
    public Object getValue() {
        return date;
    }
    /**
     *
     * @return String
     */
    public String toString(){
        return date.toString();
    }
}
