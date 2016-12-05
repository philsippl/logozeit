package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

    private static final double EPSILON = 1e-4;

    /**
     * @methodtype get
     */
    public double getDistance(Coordinate coordinate){

        if(!isCoordinateValid(coordinate))
            throw new IllegalArgumentException("coordinate is invalid");


        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        double otherX = coordinate.getX();
        double otherY = coordinate.getY();
        double otherZ = coordinate.getZ();
        double result = Math.sqrt(Math.pow(otherX - x, 2) + Math.pow(otherY - y, 2) + Math.pow(otherZ - z, 2));


        assert isCoordinateValid(coordinate);
        assertClassInvariants();

        return result;
    }

    /**
     * @methodtype comparison
     */
    public boolean isEqual(AbstractCoordinate coordinate){
        if(!isCoordinateValid(coordinate))
            throw new IllegalArgumentException("coordinate is invalid");
        assertClassInvariants();
        return Math.abs(this.getDistance(coordinate)) < EPSILON;
    }


    /**
     * @methodtype query
     */
    protected boolean isCoordinateValid(Coordinate cd) {

        if(!isValidDoubleValue(cd.getX()))
            return false;
        if(!isValidDoubleValue(cd.getY()))
            return false;
        if(!isValidDoubleValue(cd.getZ()))
            return false;

        return true;
    }

    /**
     * @methodtype query
     */
    protected boolean isValidDoubleValue(double value) {
        if(Double.isNaN(value) || Double.isInfinite(value))
            return false;
        return true;
    }

    /**
     * @methodtype assertion
     */
    protected abstract void assertClassInvariants();
}
