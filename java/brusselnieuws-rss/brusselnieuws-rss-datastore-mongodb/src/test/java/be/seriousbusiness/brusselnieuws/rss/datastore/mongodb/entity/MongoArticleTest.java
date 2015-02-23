package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;
import java.util.ArrayList;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractArticleDTOTest;

public class MongoArticleTest extends AbstractArticleDTOTest<MongoMediumType,MongoMedium,MongoCategory,MongoAuthor,MongoCreator,MongoArticle> {

	public MongoArticleTest() {
		super(BigInteger.valueOf(38621l),
				new ArrayList<MongoAuthor>(),
				new ArrayList<MongoCategory>(),
				new ArrayList<MongoMedium>(),
				new ArrayList<MongoCreator>(),
				"&lt;p&gt;Afval is lucratiever dan ooit. En dat inspireert meer dan een Brusselaar om zijn slag te slaan. “Met afval doe je niet wat je wil,” klinkt het streng bij Alain Martens van de afvalpolitie. Wij trokken met zijn equipe door Anderlecht en Molenbeek. Van het residentiële Veeweide tot de drukke Heyvaertwijk.&lt;/p&gt;Steven Van Garsse © Brussel Deze Week",
				"http://www.brusselnieuws.be/nl/nieuws/als-er-geld-mee-valt-te-verdienen-alles-mogelijk",
				"&#039;Als er geld mee te verdienen valt, is alles mogelijk&#039;",
				System.currentTimeMillis(),true,false,true);
	}

	@Override
	public MongoArticle create() {
		return new MongoArticle.Builder().build();
	}

}
