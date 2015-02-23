package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;

/**
 * {@link FeedDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedDTOImpl extends AbstractIdDTOImpl<BigInteger> implements FeedDTO<MediumTypeDTOImpl,MediumDTOImpl,CategoryDTOImpl,AuthorDTOImpl,CreatorDTOImpl,ArticleDTOImpl> {
	private String title,link,description;
	private Collection<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>();
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private FeedDTOImpl(){}
	
	private FeedDTOImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setTitle(builder.title);
		setLink(builder.link);
		setDescription(builder.description);
		setArticleDTOs(builder.articleDTOImpls);
	}
	
	public static class Builder{
		private BigInteger id;
		private String title,link,description;
		private Collection<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>();
		
		public FeedDTOImpl build() throws IllegalArgumentException{
			return new FeedDTOImpl(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder title(final String title){
			this.title=title;
			return this;
		}
		
		public Builder link(final String link) {
			this.link=link;
			return this;
		}
		
		public Builder description(final String description) {
			this.description=description;
			return this;
		}
		
		public Builder articleDTOs(final Collection<ArticleDTOImpl> articleDTOImpls) {
			this.articleDTOImpls=articleDTOImpls;
			return this;
		}
		
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(final String title) {
		this.title=title;
	}

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public void setLink(final String link) {
		this.link=link;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(final String description) {
		this.description=description;
	}

	@Override
	public Collection<ArticleDTOImpl> getArticleDTOs() {
		return articleDTOImpls;
	}

	@Override
	public void setArticleDTOs(final Collection<ArticleDTOImpl> articleDTOImpls) {
		this.articleDTOImpls=articleDTOImpls;
	}
	
	@Override
	public void add(final ArticleDTOImpl articleDTO) {
		if(articleDTO!=null && !articleDTOImpls.contains(articleDTO)) {
			articleDTOImpls.add(articleDTO);
		}
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof FeedDTOImpl && super.equals(obj) &&
				ObjectUtil.isNullOrEqual(title,((FeedDTOImpl)obj).title) &&
				ObjectUtil.isNullOrEqual(link,((FeedDTOImpl)obj).link) &&
				ObjectUtil.isNullOrEqual(description,((FeedDTOImpl)obj).description) &&
				ObjectUtil.isNullOrEqual(articleDTOImpls,((FeedDTOImpl)obj).articleDTOImpls);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * 
				ObjectUtil.hashCode(title) * 
				ObjectUtil.hashCode(link) *
				ObjectUtil.hashCode(description) *
				ObjectUtil.hashCode(articleDTOImpls);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
	}
	
	@Override
	public Object clone() {
		final Collection<ArticleDTOImpl> clonedArticleDTOImpls=new ArrayList<ArticleDTOImpl>();
		for(final ArticleDTOImpl articleDTOImpl : articleDTOImpls) {
			clonedArticleDTOImpls.add((ArticleDTOImpl)articleDTOImpl.clone());
		}
		return new Builder().id(id).description(description).link(link).title(title).articleDTOs(clonedArticleDTOImpls).build();
	}

}
