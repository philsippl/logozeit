package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Subclass;

import java.io.Serializable;
import java.util.Date;

@Subclass
public class CompanyPhoto extends Photo implements Serializable{

    public static final String SECTOR = "sector";

    private int numberOfEmployees;
    private String name;
    private Date foundingDate;
    private String ceo;
    private long valuation;
    private CompanySector sector;

    /**
     * @methodtype constructor
     */
    public CompanyPhoto(int numberOfEmployees, String name, Date foundingDate, String ceo, long valuation, CompanySector sector) {
        assertCompanySectorNonNull(sector);
        this.numberOfEmployees = numberOfEmployees;
        this.name = name;
        this.foundingDate = foundingDate;
        this.ceo = ceo;
        this.valuation = valuation;
        this.sector = sector;
    }

    public CompanyPhoto(PhotoId id) {
        super(id);
    }

    public CompanyPhoto() {
        super();
    }

    /**
     * @methodtype get
     */
    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * @methodtype set
     */
    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    /**
     * @methodtype get
     */
    public String getName() {
        return name;
    }

    /**
     * @methodtype set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @methodtype get
     */
    public Date getFoundingDate() {
        return foundingDate;
    }

    /**
     * @methodtype set
     */
    public void setFoundingDate(Date foundingDate) {
        this.foundingDate = foundingDate;
    }

    /**
     * @methodtype get
     */
    public String getCeo() {
        return ceo;
    }

    /**
     * @methodtype set
     */
    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    /**
     * @methodtype get
     */
    public long getValuation() {
        return valuation;
    }

    /**
     * @methodtype set
     */
    public void setValuation(long valuation) {
        this.valuation = valuation;
    }

    /**
     * @methodtype get
     */
    public CompanySector getSector() {
        return sector;
    }

    /**
     * @methodtype set
     */
    public void setSector(CompanySector sector) {
        assertCompanySectorNonNull(sector);
        this.sector = sector;
    }

    private void assertCompanySectorNonNull(CompanySector cs){
        if(cs == null)
            throw new IllegalArgumentException();
    }
}
