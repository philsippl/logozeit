package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CompanyPhotoManager extends PhotoManager {

	protected static final CompanyPhotoManager instance = new CompanyPhotoManager();
	
	/**
	 * @methodtype command
	 */
	public Set<CompanyPhoto> findPhotosBySector(CompanySector sector) {
		Set<CompanyPhoto> result = new HashSet<CompanyPhoto>();
		readObjects(result, CompanyPhoto.class, CompanyPhoto.SECTOR, sector);

		for (Iterator<CompanyPhoto> i = result.iterator(); i.hasNext(); ) {
			doAddPhoto(i.next());
		}

		return result;
	}
}
