package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.util.HashSet;
import java.util.Set;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Feed;

public class FeedImpl extends AbstractContent implements Feed {
	private Set<Article> articles;
	
	/**
	 * Create a new FeedImpl without articles.
	 */
	public FeedImpl(){
		articles=new HashSet<Article>();
	}

	@Override
	public int getSize() {
		return articles.size();
	}

	@Override
	public Set<Article> getArticles() {
		return new HashSet<Article>(articles);
	}

	@Override
	public Set<Article> getArticles(final Author author) {
		final Set<Article> articles=new HashSet<Article>();
		if(author!=null){
			for(final Article article : articles){
				if(article.hasAuthor(author)){
					articles.add(article);
				}
			}
		}
		return articles;
	}

	@Override
	public Set<Article> getArticles(final Category category) {
		final Set<Article> articles=new HashSet<Article>();
		if(category!=null){
			for(final Article article : articles){
				if(article.inCategory(category)){
					articles.add(article);
				}
			}
		}
		return articles;
	}

}
