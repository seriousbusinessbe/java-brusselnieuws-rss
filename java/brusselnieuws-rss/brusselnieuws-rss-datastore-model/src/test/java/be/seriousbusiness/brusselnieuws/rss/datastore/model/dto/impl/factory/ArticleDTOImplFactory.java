package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;

public class ArticleDTOImplFactory {
	
	public static final ArticleDTOImpl createArticleMichelBorcy(){
		final ArticleDTOImpl articleDTOImpl=new ArticleDTOImpl();
		articleDTOImpl.setId(BigInteger.valueOf(4732769322l));
		articleDTOImpl.setArchived(false);
		final List<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>();
		authorDTOImpls.add(AuthorDTOImplFactory.createErikaVlieghe());
		authorDTOImpls.add(AuthorDTOImplFactory.createBrusselNieuws());
		articleDTOImpl.setAuthorDTOs(authorDTOImpls);
		final List<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>();
		categoryDTOImpls.add(CategoryDTOImplFactory.createPolitiek());
		categoryDTOImpls.add(CategoryDTOImplFactory.createSamenleving());
		articleDTOImpl.setCategoryDTOs(categoryDTOImpls);
		articleDTOImpl.setDescription("&lt;p&gt;De correctionele rechtbank van Brussel heeft donderdag geen straf uitgesproken tegen de voormalige schepen van Vorst Michel Borcy (MR). Voor de feiten die hem ten laste werden gelegd is de redelijke termijn overschreden.  De voormalige gemeentesecretaris van die gemeente, Guy Delanghe, is daarentegen vrijgesproken. &lt;/p&gt;© brusselnieuws.be");
		articleDTOImpl.setFavorite(true);
		articleDTOImpl.setLink("http://www.brusselnieuws.be/nl/nieuws/ex-schepen-van-vorst-michel-borcy-ontsnapt-aan-straf");
		final List<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>();
		mediumDTOImpls.add(MediumDTOImplFactory.createJPEGImage());
		mediumDTOImpls.add(MediumDTOImplFactory.createPNGImage());
		articleDTOImpl.setMediumDTOs(mediumDTOImpls);
		articleDTOImpl.setPublicationDate(System.currentTimeMillis());
		articleDTOImpl.setTitle("Ex-schepen van Vorst Michel Borcy ontsnapt aan straf");
		articleDTOImpl.setRead(true);
		return articleDTOImpl;
	}
	
	public static final ArticleDTOImpl createArticleNlFilmsiteCinebelVerdwijnt(){
		final ArticleDTOImpl articleDTOImpl=new ArticleDTOImpl();
		articleDTOImpl.setId(BigInteger.valueOf(8374823412l));
		articleDTOImpl.setArchived(true);
		final List<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>();
		authorDTOImpls.add(AuthorDTOImplFactory.createBrusselNieuws());
		articleDTOImpl.setAuthorDTOs(authorDTOImpls);
		final List<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>();
		categoryDTOImpls.add(CategoryDTOImplFactory.createFilm());
		categoryDTOImpls.add(CategoryDTOImplFactory.createArtikel());
		articleDTOImpl.setCategoryDTOs(categoryDTOImpls);
		articleDTOImpl.setDescription("&lt;p&gt;De Nederlandstalige versie van de filmsite cinebel.be verdwijnt. Dat is slecht nieuws voor de Nederlandstalige filmliefhebbers die een avondje uit willen plannen. De IPM-groep schrapt de site uit besparingsoverwegingen.&lt;/p&gt;EVC © brusselnieuws.be");
		articleDTOImpl.setFavorite(true);
		articleDTOImpl.setLink("http://www.brusselnieuws.be/nl/cultuur/nederlandstalige-filmsite-cinebel-verdwijnt");
		final List<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>();
		mediumDTOImpls.add(MediumDTOImplFactory.createPNGImage());
		articleDTOImpl.setMediumDTOs(mediumDTOImpls);
		articleDTOImpl.setPublicationDate(System.currentTimeMillis());
		articleDTOImpl.setTitle("Nederlandstalige filmsite Cinebel verdwijnt");
		articleDTOImpl.setRead(false);
		return articleDTOImpl;
	}
	
	public static final ArticleDTOImpl createNew(){
		final ArticleDTOImpl articleDTOImpl=new ArticleDTOImpl();
		articleDTOImpl.setArchived(true);
		final List<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>();
		authorDTOImpls.add(AuthorDTOImplFactory.createNewErikaVlieghe());
		authorDTOImpls.add(AuthorDTOImplFactory.createNewBrusselNieuws());
		articleDTOImpl.setAuthorDTOs(authorDTOImpls);
		final List<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>();
		categoryDTOImpls.add(CategoryDTOImplFactory.createNewPolitiek());
		categoryDTOImpls.add(CategoryDTOImplFactory.createNewSamenleving());
		articleDTOImpl.setCategoryDTOs(categoryDTOImpls);
		articleDTOImpl.setDescription("&lt;p&gt;De correctionele rechtbank van Brussel heeft donderdag geen straf uitgesproken tegen de voormalige schepen van Vorst Michel Borcy (MR). Voor de feiten die hem ten laste werden gelegd is de redelijke termijn overschreden.  De voormalige gemeentesecretaris van die gemeente, Guy Delanghe, is daarentegen vrijgesproken. &lt;/p&gt;© brusselnieuws.be");
		articleDTOImpl.setFavorite(true);
		articleDTOImpl.setLink("http://www.brusselnieuws.be/nl/nieuws/ex-schepen-van-vorst-michel-borcy-ontsnapt-aan-straf");
		final List<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>();
		mediumDTOImpls.add(MediumDTOImplFactory.createNewJPEGImage());
		mediumDTOImpls.add(MediumDTOImplFactory.createNewPNGImage());
		articleDTOImpl.setMediumDTOs(mediumDTOImpls);
		articleDTOImpl.setPublicationDate(System.currentTimeMillis());
		articleDTOImpl.setTitle("Ex-schepen van Vorst Michel Borcy ontsnapt aan straf");
		articleDTOImpl.setRead(true);
		return articleDTOImpl;
	}

}
