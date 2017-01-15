package org.wahlzeit.model;

import java.util.Date;

public class Company {

    private int numberOfEmployees;
    private String name;
    private Date foundingDate;
    private String ceo;
    private long valuation;
    private CompanyType type;

    /**
     * @methodtype constructor
     */
    public Company(int numberOfEmployees, String name, Date foundingDate, String ceo, long valuation, CompanyType type) {
        this.numberOfEmployees = numberOfEmployees;
        this.name = name;
        this.foundingDate = foundingDate;
        this.ceo = ceo;
        this.valuation = valuation;
        this.type = type;
    }

    public Company() {
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

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public String toString(){
        return name + foundingDate + type;
    }

}
