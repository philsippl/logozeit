package org.wahlzeit.model;

public class Coordinate {

    public static final int EARTH_RADIUS = 6371;

    private double latitude;
    private double longitude;

    public Coordinate() {}

    public Coordinate(double latitude, double longitude) {
        isLatitudeValid(latitude);
        isLongitudeValid(longitude);
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getDistance(Coordinate coordinate){
        double lat = coordinate.getLatitude();
        double lon = coordinate.getLongitude();
        double lambda = Math.abs(lon - longitude);
        double sigma = Math.acos(Math.sin(latitude) * Math.sin(lat) + Math.cos(latitude) * Math.cos(lat) * Math.cos(lambda));
        return sigma * EARTH_RADIUS;
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