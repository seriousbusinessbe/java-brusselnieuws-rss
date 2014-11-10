package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;

public class CategoryDTOImplFactory {
	
	public static final CategoryDTOImpl createPolitiek(){
		final CategoryDTOImpl categoryDTOImpl=createNewPolitiek();
		categoryDTOImpl.setId(BigInteger.valueOf(468238l));
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createNewPolitiek(){
		final CategoryDTOImpl categoryDTOImpl=new CategoryDTOImpl();
		categoryDTOImpl.setLink("http://www.brusselnieuws.be/nl/bn-section/politiek");
		categoryDTOImpl.setName("Politiek");
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createSamenleving(){
		final CategoryDTOImpl categoryDTOImpl=createNewSamenleving();
		categoryDTOImpl.setId(BigInteger.valueOf(532178900l));
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createNewSamenleving(){
		final CategoryDTOImpl categoryDTOImpl=new CategoryDTOImpl();
		categoryDTOImpl.setLink("http://www.brusselnieuws.be/nl/bn-section/samenleving");
		categoryDTOImpl.setName("Samenleving");
		return categoryDTOImpl;
	}

}
