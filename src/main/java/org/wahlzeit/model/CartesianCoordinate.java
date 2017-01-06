package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(patternName = "TemplateMethod", participants = {"ConcreteClass"})
public class CartesianCoordinate extends AbstractCoordinate{
    private double x;
    private double y;
    private double z;

    /**
     * @methodtype constructor
     */
    private CartesianCoordinate() {
        this.x = 0.f;
        this.y = 0.f;
        this.z = 0.f;
    }

    /**
     * @methodtype constructor
     */
    private CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        assertClassInvariants();
    }

    /**
     * @methodtype factory method
     */
    public static CartesianCoordinate getInstance() {
        return getInstance(0.f, 0.f, 0.f);
    }

    /**
     * @methodtype factory method
     */
    public static CartesianCoordinate getInstance(double x, double y, double z) {
        CartesianCoordinate cc = new CartesianCoordinate(x, y, z);
        return (CartesianCoordinate) getInstance(cc);
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
        assertValidDoubleValue(x);
        assertValidDoubleValue(y);
        assertValidDoubleValue(z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartesianCoordinate that = (CartesianCoordinate) o;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        return Double.compare(that.z, z) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
