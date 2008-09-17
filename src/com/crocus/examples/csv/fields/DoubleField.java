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
public class DoubleField implements CSVField {
    private double value = 0.0f;
    /**
     *
     * @param value double
     */
    public DoubleField(double value) {
        this.value = value;
    }

    /**
     *
     * @return int
     */
    public int getType() {
        return FieldConstants.DOUBLE;
    }

    /**
     *
     * @return Object
     */
    public Object getValue() {
        return value;
    }

    /**
     *
     * @return double
     */
    public double getDouble() {
        return value;
    }

    /**
     *
     * @return String
     */
    public String toString() {
        return String.valueOf(value);
    }

}
