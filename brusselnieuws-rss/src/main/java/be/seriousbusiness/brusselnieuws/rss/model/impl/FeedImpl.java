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
	 * @param title
	 * @throws IllegalArgumentException when the title is <code>null</code>
	 */
	protected FeedImpl(final String title) throws IllegalArgumentException{
		super(title);
		articles=new HashSet<Article>();
	}

	@Override
	public int size() {
		return articles.size();
	}
	
	protected void addArticle(final Article article){
		if(article!=null && !articles.contains(article)){
			articles.add(article);
		}
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
				if(article.hasCategory(category)){
					articles.add(article);
				}
			}
		}
		return articles;
	}
	
	@Override
	public String toString(){
		final StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(getTitle());
		for(final Article article : articles){
			stringBuilder.append("\n").append(article);
		}
		return stringBuilder.toString();
	}

}
