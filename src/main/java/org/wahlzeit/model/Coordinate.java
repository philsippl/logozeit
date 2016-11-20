package org.wahlzeit.model;

public interface Coordinate {

    /**
     * @methodtype get
     */
    public double getX();

    /**
     * @methodtype get
     */
    public double getY();

    /**
     * @methodtype get
     */
    public double getZ();

    /**
     * @methodtype get
     */
    public double getDistance(Coordinate cd);

}
