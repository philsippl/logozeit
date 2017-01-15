package org.wahlzeit.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CompanyManager {

    private static CompanyManager instance = null;
    private Map<String, Company> companies = new HashMap<>();
    private Map<String, CompanyType> companyTypes = new HashMap<String, CompanyType>();

    /**
     * @methodtype constructor
     */
    private CompanyManager() {}

    /**
     * @methodtype factory method
     */
    public static synchronized CompanyManager getInstance() {
        if (instance == null)
            instance = new CompanyManager();

        return instance;
    }

    /**
     * @methodtype set
     */
    private CompanyType addCompanyType(CompanyType type) {
        if(!companyTypes.containsKey(type.toString()))
            companyTypes.put(type.toString(), type);
        else
            type = companyTypes.get(type.toString());
        return type;
    }

    /**
     * @methodtype get
     */
    public CompanyType createCompanyType(CompanySector sector) {
        return addCompanyType(new CompanyType(sector));
    }

    /**
     * @methodtype get
     */
    public Company createCompany(int numberOfEmployees, String name, Date foundingDate, String ceo, long valuation, CompanyType type) {
        type = addCompanyType(type);
        Company result = type.createInstance(numberOfEmployees, name, foundingDate, ceo, valuation);
        companies.put(result.toString(), result);
        return result;
    }

}
