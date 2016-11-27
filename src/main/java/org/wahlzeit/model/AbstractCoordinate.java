package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

    private static final double EPSILON = 1e-4;

    /**
     * @methodtype get
     */
    public double getDistance(Coordinate coordinate){
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        double otherX = coordinate.getX();
        double otherY = coordinate.getY();
        double otherZ = coordinate.getZ();
        return Math.sqrt(Math.pow(otherX - x, 2) + Math.pow(otherY - y, 2) + Math.pow(otherZ - z, 2));
    }

    public boolean isEqual(AbstractCoordinate coordinate){
        return Math.abs(this.getDistance(coordinate)) < EPSILON;
    }

}
