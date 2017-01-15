package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.utils.PatternInstance;

import java.io.Serializable;
import java.util.Date;

@PatternInstance(patternName = "Abstract Factory", participants = {"Concrete Product"})
@Subclass
public class CompanyPhoto extends Photo implements Serializable{

    public static final String SECTOR = "sector";

    private Company company;

    public CompanyPhoto(Company company) {
        this.company = company;
    }

    public CompanyPhoto(PhotoId myId, Company company) {
        super(myId);
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
