package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

import java.net.URL;
import java.util.Collection;

/**
 * Web service response bean containing feed data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedResponse extends AbstractIdResponse {
	private String title;
	private URL link;
	private String description;
	private Collection<ArticleResponse> articles;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(final String title) {
		this.title = title;
	}
	
	public URL getLink() {
		return link;
	}
	
	public void setLink(final URL link) {
		this.link = link;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(final String description) {
		this.description = description;
	}
	
	public Collection<ArticleResponse> getArticles() {
		return articles;
	}
	
	public void setArticles(final Collection<ArticleResponse> articles) {
		this.articles = articles;
	}
	
}
