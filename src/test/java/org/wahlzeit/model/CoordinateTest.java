package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoordinateTest {

    private static double DELTA = 10e-4;

    @Before
    public void setUp() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLongitudeConstructor() {
        new Coordinate(20, 10000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLatitudeConstructor() {
        new Coordinate(10000, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLongitude() {
        Coordinate c = new Coordinate();
        c.setLongitude(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLatitude() {
        Coordinate c = new Coordinate();
        c.setLatitude(1000);
    }

    @Test
    public void testSameDistance() {
        Coordinate c = new Coordinate(45,45);
        assertEquals(c.getDistance(c), 0.0d, DELTA);
    }

    @Test
    public void testSameDistanceTwoSidesLat() {
        Coordinate c1 = new Coordinate(0,0);
        Coordinate c2 = new Coordinate(90,0);
        Coordinate c3 = new Coordinate(-90,0);
        assertEquals(c1.getDistance(c2), c1.getDistance(c3), DELTA);
    }

    @Test
    public void testSameDistanceTwoSidesLon() {
        Coordinate c1 = new Coordinate(0,0);
        Coordinate c2 = new Coordinate(0,180);
        Coordinate c3 = new Coordinate(0,-180);
        assertEquals(c1.getDistance(c2), c1.getDistance(c3), DELTA);
    }

    @Test
    public void testDistance() {
        Coordinate c1 = new Coordinate(10,30);
        Coordinate c2 = new Coordinate(40, 100);
        assertEquals(c1.getDistance(c2), 10332.263, DELTA);
    }

}
