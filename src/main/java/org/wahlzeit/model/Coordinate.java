package org.wahlzeit.model;

public interface Coordinate {

    /**
     * @methodtype get
     */
    double getX();

    /**
     * @methodtype get
     */
    double getY();

    /**
     * @methodtype get
     */
    double getZ();

    /**
     * @methodtype get
     */
    double getDistance(Coordinate cd);

}
