package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CreatorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;

/**
 * {@link ArticleDTOImpl} factory.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class ArticleDTOImplFactory {
	
	/**
	 * Creates an existing {@link ArticleDTOImpl}.
	 * @return
	 */
	public static final ArticleDTOImpl createArticleMichelBorcy(){		
		final List<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>();
		authorDTOImpls.add(AuthorDTOImplFactory.createErikaVlieghe());
		authorDTOImpls.add(AuthorDTOImplFactory.createBrusselNieuws());
		final List<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>();
		categoryDTOImpls.add(CategoryDTOImplFactory.createPolitiek());
		categoryDTOImpls.add(CategoryDTOImplFactory.createSamenleving());
		final List<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>();
		mediumDTOImpls.add(MediumDTOImplFactory.createJPEGImage());
		mediumDTOImpls.add(MediumDTOImplFactory.createPNGImage());
		final List<CreatorDTOImpl> creatorDTOImpls=new ArrayList<CreatorDTOImpl>();
		creatorDTOImpls.add(CreatorDTOImplFactory.createBrusselNieuwsBe());
		creatorDTOImpls.add(CreatorDTOImplFactory.createFMBrussel());
		return new ArticleDTOImpl.Builder().id(BigInteger.valueOf(4732769322l))
				.archived(false)
				.authorDTOs(authorDTOImpls)
				.categoryDTOs(categoryDTOImpls)
				.creatorDTOs(creatorDTOImpls)
				.description("&lt;p&gt;De correctionele rechtbank van Brussel heeft donderdag geen straf uitgesproken tegen de voormalige schepen van Vorst Michel Borcy (MR). Voor de feiten die hem ten laste werden gelegd is de redelijke termijn overschreden.  De voormalige gemeentesecretaris van die gemeente, Guy Delanghe, is daarentegen vrijgesproken. &lt;/p&gt;© brusselnieuws.be")
				.favorite(true)
				.link("http://www.brusselnieuws.be/nl/nieuws/ex-schepen-van-vorst-michel-borcy-ontsnapt-aan-straf")
				.mediumDTOs(mediumDTOImpls)
				.publicationDate(System.currentTimeMillis())
				.title("Ex-schepen van Vorst Michel Borcy ontsnapt aan straf")
				.read(true).build();
	}
	
	/**
	 * Creates an existing {@link ArticleDTOImpl}.
	 * @return
	 */
	public static final ArticleDTOImpl createArticleNlFilmsiteCinebelVerdwijnt(){
		final List<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>();
		authorDTOImpls.add(AuthorDTOImplFactory.createBrusselNieuws());
		final List<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>();
		categoryDTOImpls.add(CategoryDTOImplFactory.createFilm());
		categoryDTOImpls.add(CategoryDTOImplFactory.createArtikel());
		final List<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>();
		mediumDTOImpls.add(MediumDTOImplFactory.createPNGImage());
		final List<CreatorDTOImpl> creatorDTOImpls=new ArrayList<CreatorDTOImpl>();
		creatorDTOImpls.add(CreatorDTOImplFactory.createBrusselNieuwsBe());
		creatorDTOImpls.add(CreatorDTOImplFactory.createTVBrussel());
		return new ArticleDTOImpl.Builder().id(BigInteger.valueOf(8374823412l))
				.archived(true)
				.authorDTOs(authorDTOImpls)
				.categoryDTOs(categoryDTOImpls)
				.creatorDTOs(creatorDTOImpls)
				.description("&lt;p&gt;De Nederlandstalige versie van de filmsite cinebel.be verdwijnt. Dat is slecht nieuws voor de Nederlandstalige filmliefhebbers die een avondje uit willen plannen. De IPM-groep schrapt de site uit besparingsoverwegingen.&lt;/p&gt;EVC © brusselnieuws.be")
				.favorite(true)
				.link("http://www.brusselnieuws.be/nl/cultuur/nederlandstalige-filmsite-cinebel-verdwijnt")
				.mediumDTOs(mediumDTOImpls)
				.publicationDate(System.currentTimeMillis())
				.title("Nederlandstalige filmsite Cinebel verdwijnt")
				.read(false).build();
	}
	
	/**
	 * Creates a new {@link ArticleDTOImpl}.
	 * @return
	 */
	public static final ArticleDTOImpl createNew(){		
		final List<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>();
		authorDTOImpls.add(AuthorDTOImplFactory.createNewErikaVlieghe());
		authorDTOImpls.add(AuthorDTOImplFactory.createNewBrusselNieuws());
		final List<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>();
		categoryDTOImpls.add(CategoryDTOImplFactory.createNewPolitiek());
		categoryDTOImpls.add(CategoryDTOImplFactory.createNewSamenleving());
		final List<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>();
		mediumDTOImpls.add(MediumDTOImplFactory.createNewJPEGImage());
		mediumDTOImpls.add(MediumDTOImplFactory.createNewPNGImage());
		final List<CreatorDTOImpl> creatorDTOImpls=new ArrayList<CreatorDTOImpl>();
		creatorDTOImpls.add(CreatorDTOImplFactory.createNewFMBrussel());
		creatorDTOImpls.add(CreatorDTOImplFactory.createNewTVBrussel());
		return new ArticleDTOImpl.Builder().archived(true)
				.authorDTOs(authorDTOImpls)
				.categoryDTOs(categoryDTOImpls)
				.creatorDTOs(creatorDTOImpls)
				.description("&lt;p&gt;De correctionele rechtbank van Brussel heeft donderdag geen straf uitgesproken tegen de voormalige schepen van Vorst Michel Borcy (MR). Voor de feiten die hem ten laste werden gelegd is de redelijke termijn overschreden.  De voormalige gemeentesecretaris van die gemeente, Guy Delanghe, is daarentegen vrijgesproken. &lt;/p&gt;© brusselnieuws.be")
				.favorite(true)
				.link("http://www.brusselnieuws.be/nl/nieuws/ex-schepen-van-vorst-michel-borcy-ontsnapt-aan-straf")
				.mediumDTOs(mediumDTOImpls)
				.publicationDate(System.currentTimeMillis())
				.title("Ex-schepen van Vorst Michel Borcy ontsnapt aan straf")
				.read(true).build();
	}

}
