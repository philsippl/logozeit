package org.wahlzeit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CompanyType {

    private CompanySector sector;

    public Set<CompanyType> subTypes = new HashSet<>();


    public CompanyType(CompanySector sector) {
        this.sector = sector;
    }

    public Company createInstance(int numberOfEmployees, String name, Date foundingDate, String ceo, long valuation) {
        return new Company(numberOfEmployees, name, foundingDate, ceo,  valuation, this);
    }

    /**
     * @methodtype query
     */
    public boolean isInstance(Company company) {
        if(company.getType() == this)
            return true;
        for(CompanyType type : subTypes) {
            if(type.isInstance(company))
                return true;
        }

        return false;
    }

    /**
     * @methodtype query
     */
    public boolean isSubtype(CompanyType companyType) {
        for (CompanyType tmp : subTypes) {
            if (tmp == companyType) {
                return true;
            }
        }
        return false;
    }

    public CompanySector getSector(){
        return this.sector;
    }

    /**
     * @methodtype set
     */
    public void addSubType(CompanyType type) {
        subTypes.add(type);
    }

    public String toString(){
        return sector.toString();
    }

}
