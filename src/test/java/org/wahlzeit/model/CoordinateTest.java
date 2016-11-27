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
        new SphericCoordinate(20, 10000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLatitudeConstructor() {
        new SphericCoordinate(10000, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLongitude() {
        SphericCoordinate c = new SphericCoordinate();
        c.setLatitude(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLatitude() {
        SphericCoordinate c = new SphericCoordinate();
        c.setLatitude(1000);
    }

    @Test
    public void testSameDistanceSpheric() {
        Coordinate c = new SphericCoordinate(45,45);
        assertEquals(c.getDistance(c), 0.0d, DELTA);
    }

    @Test
    public void testSameDistanceTwoSidesLatSpheric() {
        SphericCoordinate c1 = new SphericCoordinate(0,0);
        SphericCoordinate c2 = new SphericCoordinate(90,0);
        SphericCoordinate c3 = new SphericCoordinate(-90,0);
        assertEquals(c1.getDistance(c2), c1.getDistance(c3), DELTA);
    }

    @Test
    public void testSameDistanceTwoSidesLonSpheric() {
        SphericCoordinate c1 = new SphericCoordinate(0,0);
        SphericCoordinate c2 = new SphericCoordinate(0,180);
        SphericCoordinate c3 = new SphericCoordinate(0,-180);
        assertEquals(c1.getDistance(c2), c1.getDistance(c3), DELTA);
    }

    @Test
    public void testDistanceSpheric() {
        SphericCoordinate c1 = new SphericCoordinate(10,30);
        SphericCoordinate c2 = new SphericCoordinate(47,11);
        assertEquals(c1.getDistance(c2), 2445.8749, DELTA);
    }

    @Test
    public void testDistanceCartesian() {
        //same coordinates as used in testDistanceSpheric, converted with http://keisan.casio.com/exec/system/1359534351
        CartesianCoordinate c1 = new CartesianCoordinate(3137.105097, 553.15627, 5517.447848);
        CartesianCoordinate c2 = new CartesianCoordinate(829.0672891,889.0658194, 6253.946786);
        assertEquals(c1.getDistance(c2), 2445.8749, DELTA);
    }

    @Test
    public void testSameCoordinateSphericCartesian() {
        SphericCoordinate c1 = new SphericCoordinate(10,30);
        CartesianCoordinate c2 = new CartesianCoordinate(3137.105097, 553.15627, 5517.447848);
        //converted with http://keisan.casio.com/exec/system/1359534351
        assertEquals(c1.getX(), c2.getX(), DELTA);
        assertEquals(c1.getY(), c2.getY(), DELTA);
        assertEquals(c1.getZ(), c2.getZ(), DELTA);
        assertTrue(c1.isEqual(c2));
    }

    @Test
    public void testSameDistanceSphericCartesian() {
        SphericCoordinate c1 = new SphericCoordinate(10,30);
        //converted with http://keisan.casio.com/exec/system/1359534351
        CartesianCoordinate c2 = new CartesianCoordinate(3137.105097, 553.15627, 5517.447848);
        assertEquals(c1.getDistance(c2), 0, DELTA);
        assertTrue(c1.isEqual(c2));
    }

    @Test
    public void testSameCoordinateseCartesian() {
        CartesianCoordinate c1 = new CartesianCoordinate(10, 10, 10);
        CartesianCoordinate c2 = new CartesianCoordinate(10, 10, 10);
        assertEquals(c1.getDistance(c2), 0, DELTA);
        assertTrue(c1.isEqual(c2));
    }




}
