package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import java.util.HashMap;

@PatternInstance(patternName = "TemplateMethod", participants = {"AbstractClass"})
public abstract class AbstractCoordinate implements Coordinate{

    private static final double EPSILON = 1e-4;
    static final int MAX_SIZE = 1024;
    protected static HashMap<Integer, AbstractCoordinate> instances = new HashMap<>(MAX_SIZE);

    /**
     * @methodtype get
     */
    public double getDistance(Coordinate coordinate){

        assertNonNullCoordinate(coordinate);
        assertValidCoordinate(coordinate);


        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        double otherX = coordinate.getX();
        double otherY = coordinate.getY();
        double otherZ = coordinate.getZ();
        double result = Math.sqrt(Math.pow(otherX - x, 2) + Math.pow(otherY - y, 2) + Math.pow(otherZ - z, 2));


        assertValidCoordinate(coordinate);
        assertClassInvariants();

        return result;
    }

    /**
     * @methodtype comparison
     */
    public boolean isEqual(AbstractCoordinate coordinate){
        assertNonNullCoordinate(coordinate);
        assertValidCoordinate(coordinate);
        assertClassInvariants();

        boolean result = Math.abs(this.getDistance(coordinate)) < EPSILON;

        assertClassInvariants();

        return result;
    }


    /**
     * @methodtype assertion
     */
    protected void assertValidCoordinate(Coordinate cd) {
        assertValidDoubleValue(cd.getX());
        assertValidDoubleValue(cd.getY());
        assertValidDoubleValue(cd.getZ());
    }

    /**
     * @methodtype assertion
     */
    protected void assertNonNullCoordinate(Coordinate cd) {
        if(cd == null)
            throw new IllegalArgumentException("null coordinate is not allowed");
    }

    /**
     * @methodtype assertion
     */
    protected void assertValidDoubleValue(double value) {
        if(Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("non valid value: "+value);
    }

    /**
     * @methodtype assertion
     */
    protected abstract void assertClassInvariants();

    /**
     * @methodtype factory
     */
    protected synchronized static AbstractCoordinate getInstance(AbstractCoordinate coordinate) {
        AbstractCoordinate res = instances.get(coordinate.hashCode());
        if(res == null || !res.equals(coordinate) || !(res.getClass().equals(coordinate.getClass()))) {
                instances.put(coordinate.hashCode(), coordinate);
                return coordinate;
        }

        return res;
    }

}
