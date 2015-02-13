package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.reader.model.comparator.ArticlePublicationDateComparator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.listener.FeedListener;

public class FeedImpl extends AbstractIdImpl<BigInteger> implements Feed<MediumTypeImpl,MediumImpl,CategoryImpl,AuthorImpl,ArticleImpl> {
	private String title;
	private URL link;
	private String description;
	private Collection<ArticleImpl> articles=new ArrayList<ArticleImpl>();
	private Set<FeedListener> feedListeners=new HashSet<FeedListener>();
	private static final Comparator<Article<?,?,?,?>> ARTICLE_COMPARATOR=new ArticlePublicationDateComparator();
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private FeedImpl(){}
	
	private FeedImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setTitle(builder.title);
		setLink(builder.link);
		if(builder.description!=null){
			setDescription(builder.description);
		}
		setArticles(builder.articles);
	}
	
	public static class Builder{
		private BigInteger id;
		private String title,description;
		private URL link;
		private Collection<ArticleImpl> articles=new ArrayList<ArticleImpl>();
		
		public FeedImpl build() throws IllegalArgumentException{
			return new FeedImpl(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder title(final String title){
			this.title=title;
			return this;
		}
		
		public Builder link(final URL link){
			this.link=link;
			return this;
		}
		
		public Builder description(final String description){
			this.description=description;
			return this;
		}
		
		public Builder articles(final Collection<ArticleImpl> articles){
			this.articles=articles;
			return this;
		}
		
	}

	@Override
	public void attach(final FeedListener feedListener) {
		if(feedListener!=null){
			feedListeners.add(feedListener);
		}
	}

	@Override
	public void detach(final FeedListener feedListener) {
		if(feedListener!=null){
			feedListeners.remove(feedListener);
		}
	}
	
	private void notifyFeedListeners(final ArticleImpl article){
		for(final FeedListener feedListener : feedListeners){
			feedListener.notify(this, article);
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(final String title) throws IllegalArgumentException {
		if(title==null || title.isEmpty()){
			throw new IllegalArgumentException("The title is null or empty");
		}
		this.title=title.trim();
	}

	@Override
	public URL getLink() {
		return link;
	}

	@Override
	public void setLink(final URL link) throws IllegalArgumentException {
		if(link==null){
			throw new IllegalArgumentException("The link is null");
		}
		this.link=link;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(final String description) {
		if(description!=null && !description.isEmpty()){
			this.description=description.trim();
		}
	}

	@Override
	public boolean hasDescription() {
		return description!=null;
	}

	@Override
	public int numberOfArticles() {
		return articles.size();
	}

	@Override
	public Collection<ArticleImpl> getArticles() {
		final List<ArticleImpl> articles=new ArrayList<ArticleImpl>(this.articles);
		Collections.sort(articles,ARTICLE_COMPARATOR);
		return articles;
	}

	@Override
	public void setArticles(final Collection<ArticleImpl> articles) {
		if(articles!=null){
			for(final ArticleImpl article : articles){
				add(article);
			}
		}
	}
	
	@Override
	public void add(final ArticleImpl article) {
		if(article!=null && !articles.contains(article)){
			articles.add(article);
			notifyFeedListeners(article);
		}
	}

	@Override
	public boolean hasArticle(final ArticleImpl article) {
		return articles.contains(article);
	}

	@Override
	public Collection<ArticleImpl> getArticles(final AuthorImpl author) {
		final List<ArticleImpl> articles=new ArrayList<ArticleImpl>();
		for(final ArticleImpl article : this.articles){
			if(article.hasAuthor(author)){
				articles.add(article);
			}
		}
		Collections.sort(articles,ARTICLE_COMPARATOR);
		return articles;
	}

	@Override
	public Collection<ArticleImpl> getArticles(final CategoryImpl category) {
		final List<ArticleImpl> articles=new ArrayList<ArticleImpl>();
		for(final ArticleImpl article : this.articles){
			if(article.hasCategory(category)){
				articles.add(article);
			}
		}
		Collections.sort(articles,ARTICLE_COMPARATOR);
		return articles;
	}

	@Override
	public Collection<ArticleImpl> getArticles(final boolean archived) {
		final List<ArticleImpl> articles=new ArrayList<ArticleImpl>();
		for(final ArticleImpl article : this.articles){
			if(article.isArchived()==archived){
				articles.add(article);
			}
		}
		Collections.sort(articles,ARTICLE_COMPARATOR);
		return articles;
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof FeedImpl && 
				ObjectUtil.isNullOrEqual(title,((FeedImpl)obj).title) &&
				ObjectUtil.isNullOrEqual(link,((FeedImpl)obj).link) &&
				ObjectUtil.isNullOrEqual(description,((FeedImpl)obj).description) &&
				ObjectUtil.isNullOrEqual(articles,((FeedImpl)obj).articles);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(title) * 
				ObjectUtil.hashCode(link) *
				ObjectUtil.hashCode(description) *
				ObjectUtil.hashCode(articles);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
	}

}
