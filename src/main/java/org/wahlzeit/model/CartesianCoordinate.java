package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{
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
     * @methodtype get
     */
    @Override
    public double getDistance(Coordinate cd) {
        if(cd == null)
            throw new IllegalArgumentException();

        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        double otherX = cd.getX();
        double otherY = cd.getY();
        double otherZ = cd.getZ();
        return Math.sqrt(Math.pow(otherX - x, 2) + Math.pow(otherY - y, 2) + Math.pow(otherZ - z, 2));
    }


}
