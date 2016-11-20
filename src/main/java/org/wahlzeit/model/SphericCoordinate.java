package org.wahlzeit.model;


public class SphericCoordinate implements Coordinate{

    public static final int EARTH_RADIUS = 6371;

    private double latitude;
    private double longitude;
    private double radius;

    public SphericCoordinate() {}

    public SphericCoordinate(double latitude, double longitude, double radius) {
        isLatitudeValid(latitude);
        isLongitudeValid(longitude);
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public SphericCoordinate(double latitude, double longitude) {
        this(latitude, longitude, EARTH_RADIUS);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        isLatitudeValid(latitude);
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        isLatitudeValid(longitude);
        this.longitude = longitude;
    }

    /**
     * @methodtype get
     * formula: http://keisan.casio.com/exec/system/1359534351
     */
    @Override
    public double getX() {
        return radius * Math.sin(Math.toRadians(this.longitude)) * Math.cos(Math.toRadians(this.latitude));
    }

    /**
     * @methodtype get
     * formula: http://keisan.casio.com/exec/system/1359534351
     */
    @Override
    public double getY() {
        return radius * Math.sin(Math.toRadians(this.longitude)) * Math.sin(Math.toRadians(this.latitude));
    }

    /**
     * @methodtype get
     * formula: http://keisan.casio.com/exec/system/1359534351
     */
    @Override
    public double getZ() {
        return radius * Math.cos(Math.toRadians(this.longitude));
    }

    /**
     * @methodtype get
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @methodtype set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

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

    private void isLatitudeValid(double lat) throws IllegalArgumentException{
        if(lat < -90 || lat > 90){
            throw new IllegalArgumentException();
        }
    }

    private void isLongitudeValid(double lon) throws IllegalArgumentException{
        if(lon < -180 || lon > 180){
            throw new IllegalArgumentException();
        }
    }


}
