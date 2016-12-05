package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{
    private double x;
    private double y;
    private double z;

    /**
     * @methodtype constructor
     */
    public CartesianCoordinate() {
        this.x = 0.f;
        this.y = 0.f;
        this.z = 0.f;
    }

    /**
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @methodtype get
     */
    public double getX() {
        return this.x;
    }

    /**
     * @methodtype get
     */
    public double getY() {
        return this.y;
    }

    /**
     * @methodtype get
     */
    public double getZ() {
        return this.z;
    }


    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants() {
        assert isValidDoubleValue(x);
        assert isValidDoubleValue(y);
        assert isValidDoubleValue(z);
    }


}
