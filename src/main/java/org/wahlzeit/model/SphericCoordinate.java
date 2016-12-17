package org.wahlzeit.model;


public class SphericCoordinate extends AbstractCoordinate{

    public static final int EARTH_RADIUS = 6371;

    private double latitude;
    private double longitude;
    private double radius;

    private SphericCoordinate() {}

    private SphericCoordinate(double latitude, double longitude, double radius) {
        assertLatitudeLongitudeValid(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        assertClassInvariants();
    }

    private SphericCoordinate(double latitude, double longitude) {
        this(latitude, longitude, EARTH_RADIUS);
    }

    public static SphericCoordinate getInstance() {
        return getInstance(0.f, 0.f, 0.f);
    }

    public static SphericCoordinate getInstance(double latitude, double longitude) {
        return getInstance(latitude, longitude, EARTH_RADIUS);
    }

    public static SphericCoordinate getInstance(double latitude, double longitude, double radius) {
        SphericCoordinate sc = new SphericCoordinate(latitude, longitude, radius);
        return (SphericCoordinate) getInstance(sc);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        assertLatitudeValid(latitude);
        this.latitude = latitude;
        assertClassInvariants();
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        assertLatitudeValid(longitude);
        this.longitude = longitude;
        assertClassInvariants();
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
     * @methodtype assertion
     */
    private void assertLatitudeValid(double lat) throws IllegalArgumentException{
        if(lat < -90 || lat > 90){
            throw new IllegalArgumentException();
        }
    }

    /**
     * @methodtype assertion
     */
    private void assertLongitudeValid(double lon) throws IllegalArgumentException{
        if(lon < -180 || lon > 180){
            throw new IllegalArgumentException();
        }
    }

    /**
     * @methodtype assertion
     */
    private void assertLatitudeLongitudeValid(double lat, double lon){
        assertLatitudeValid(lat);
        assertLongitudeValid(lon);
    }

    /**
     * @methodtype assertion
     */
    private void assertRadiusValid(){
        if(radius <= 0)
            throw new IllegalArgumentException();
    }


    @Override
    protected void assertClassInvariants() {
        assertRadiusValid();
        assertValidDoubleValue(latitude);
        assertValidDoubleValue(longitude);
        assertLatitudeLongitudeValid(latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SphericCoordinate that = (SphericCoordinate) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        return Double.compare(that.radius, radius) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
