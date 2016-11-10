package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CompanyPhotoFactoryTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testFactorySingletonSameObject() {
        CompanyPhotoFactory factory = CompanyPhotoFactory.getInstance();
        CompanyPhotoFactory factory2 = CompanyPhotoFactory.getInstance();
        assertEquals(factory, factory2);
    }

    @Test(expected = IllegalStateException.class)
    public void testFactorySingletonOverwrite() {
        CompanyPhotoFactory.getInstance();
        CompanyPhotoFactory.setInstance(new CompanyPhotoFactory());
    }


}
