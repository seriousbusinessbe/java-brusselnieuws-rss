package be.seriousbusiness.brusselnieuws.rss.reader.util;

import org.jsoup.Jsoup;

public class StringUtil {

	public static final String removeHTMLTags(final String text) {
		return Jsoup.parse(text).body().text();
	}

}
