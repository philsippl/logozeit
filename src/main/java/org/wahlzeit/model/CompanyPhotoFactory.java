package org.wahlzeit.model;

import java.util.Date;
import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

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
    public CompanyPhoto createPhoto() {
        return new CompanyPhoto();
    }

    /**
     * @methodtype factory
     */
    public CompanyPhoto createPhoto(PhotoId id) {
        return new CompanyPhoto(id);
    }

    /**
     * @methodtype factory
     */
    public CompanyPhoto createPhoto(int numberOfEmployees, String name, Date foundingDate, String ceo, long valuation, CompanySector sector){
        return new CompanyPhoto(numberOfEmployees, name, foundingDate, ceo, valuation, sector);
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