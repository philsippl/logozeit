package org.wahlzeit.model;

import java.util.Date;
import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.PatternInstance;

@PatternInstance(patternName = "Abstract Factory", participants = {"Concrete Factory"})
public class CompanyPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(CompanyPhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static CompanyPhotoFactory instance = null;

    /**
     *	methodtype constructor
     */
    public CompanyPhotoFactory() {
        //do nothing
    }

    /**
     * @methodtype factory
     */
    public CompanyPhoto createPhoto(Company company) {
        return new CompanyPhoto(company);
    }

    /**
     * @methodtype factory
     */
    public CompanyPhoto createPhoto(PhotoId id, Company company) {
        return new CompanyPhoto(id, company);
    }

    /**
     * methodtype get
     */
    public static synchronized CompanyPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting CompanyPhotoFactory").toString());
            setInstance(new CompanyPhotoFactory());
        }

        return instance;
    }

    /**
     * methodtype set
     */
    protected static synchronized void setInstance(CompanyPhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize CompanyPhotoFactory twice");
        }

        instance = photoFactory;
    }

}