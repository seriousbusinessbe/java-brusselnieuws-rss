package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableFeed;
import be.seriousbusiness.brusselnieuws.rss.model.comparator.ArticlePublicationDateComparator;
import be.seriousbusiness.brusselnieuws.rss.model.impl.ManagerUtil;
import be.seriousbusiness.brusselnieuws.rss.model.listener.FeedListener;

public class AdaptableFeedImpl extends AbstractAdaptableContent<Long> implements AdaptableFeed {
	private Set<Article> articles=new HashSet<Article>();
	private Set<FeedListener> feedListeners=new HashSet<FeedListener>();
	
	public static class Builder {
		private Long id;
		private String title,description;
		private URL link;
		private final Set<Article> articles=new HashSet<Article>();

		public AdaptableFeedImpl build() {
			return new AdaptableFeedImpl(this);
		}
		
		public Builder id(final long id){
			this.id=id;
			return this;
		}
		
		public Builder title(final String title) {
			this.title=title;
			return this;
		}

		public Builder link(final URL link) {
			this.link=link;
			return this;
		}

		public Builder description(final String description) {
			this.description=description;
			return this;
		}

		public Builder add(final Article article) {
			articles.add(article);
			return this;
		}

	}
	
	private AdaptableFeedImpl(final Builder builder) throws IllegalArgumentException{
		this(builder.title);
		if(builder.id!=null){
			setId(builder.id);
		}
		if(builder.description!=null){
			setDescription(builder.description);
		}
		if(builder.link!=null){
			setLink(builder.link);
		}
		for(final Article article : builder.articles){
			add(article);
		}
	}
	
	/**
	 * Create a new FeedImpl without articles.
	 * @param title
	 * @throws IllegalArgumentException when the title is <code>null</code>
	 */
	protected AdaptableFeedImpl(final String title) throws IllegalArgumentException{
		super(title);
	}
	
	public AdaptableFeedImpl(){
	}

	@Override
	public int size() {
		return articles.size();
	}
	
	@Override
	public boolean hasArticle(final Article article) {
		return articles.contains(article);
	}
	
	@Override
	public Article add(final Article article){
		if(article!=null && !articles.contains(article)){
			if(articles.contains(article)){
				for(final Article a : articles){
					if(a.equals(article)){
						return a;
					}
				}
			}else{
				articles.add(article);
			}
			notify(article);
		}
		return article;
	}
	
	private static final List<Article> orderByPublicationDate(final Set<Article> articles){
		return ManagerUtil.toOrderedList(articles,new ArticlePublicationDateComparator());
	}

	@Override
	public List<Article> getArticles() {
		return orderByPublicationDate(articles);
	}

	@Override
	public List<Article> getArticles(final Author author) {
		final Set<Article> articles=new HashSet<Article>();
		if(author!=null){
			for(final Article article : this.articles){
				if(article.hasAuthor(author)){
					articles.add(article);
				}
			}
		}
		return orderByPublicationDate(articles);
	}

	@Override
	public List<Article> getArticles(final Category category) {
		final Set<Article> articles=new HashSet<Article>();
		if(category!=null){
			for(final Article article : this.articles){
				if(article.hasCategory(category)){
					articles.add(article);
				}
			}
		}
		return orderByPublicationDate(articles);
	}
	
	@Override
	public List<Article> getArticles(final boolean archived) {
		final Set<Article> articles=new HashSet<Article>();
		for(final Article article : this.articles){
			if(article.isArchived()==archived){
				articles.add(article);
			}
		}
		return orderByPublicationDate(articles);
	}
	
	@Override
	public void setArticles(final List<Article> articles) {
		if(articles!=null){
			for(final Article article : articles){
				add(article);
			}
		}
	}	
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof Feed && articles.equals(((Feed)obj).getArticles()) && super.equals(obj);
	}
	
	@Override
	public int hashCode(){
		return articles.hashCode() * super.hashCode();
	}
	
	@Override
	public String toString(){
		final StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(super.toString()).append(" ");
		stringBuilder.append(getTitle());
		for(final Article article : getArticles()){
			stringBuilder.append("\n").append(article);
		}
		return stringBuilder.toString();
	}
	
	/**
	 * Notify all attached FeedListeners of a new Article.
	 * @param article the new Article
	 */
	private void notify(final Article article){
		for(final FeedListener feedListener : feedListeners){
			feedListener.notify(this,article);
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
		feedListeners.remove(feedListener);
	}

}
