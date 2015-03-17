package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.CollectionsUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;

/**
 * {@link ArticleDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class ArticleDTOImpl extends AbstractIdDTOImpl<BigInteger> implements ArticleDTO<MediumTypeDTOImpl,MediumDTOImpl,CategoryDTOImpl,AuthorDTOImpl,CreatorDTOImpl> {
	private String title,link,description;
	private Long publicationDate;
	private Boolean read,archived,favorite;
	private Collection<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>();
	private Collection<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>();
	private Collection<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>();
	private Collection<CreatorDTOImpl> creatorDTOImpls=new ArrayList<CreatorDTOImpl>();
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private ArticleDTOImpl(){}
	
	private ArticleDTOImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setTitle(builder.title);
		setLink(builder.link);
		setDescription(builder.description);
		setPublicationDate(builder.publicationDate);
		setRead(builder.read);
		setArchived(builder.archived);
		setFavorite(builder.favorite);
		setMediumDTOs(builder.mediumDTOImpls);
		setCategoryDTOs(builder.categoryDTOImpls);
		setAuthorDTOs(builder.authorDTOImpls);
		setCreatorDTOs(builder.creatorDTOImpls);
	}
	
	public static class Builder{
		private BigInteger id;
		private String title,link,description;
		private Long publicationDate;
		private Boolean read,archived,favorite;
		private Collection<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>();
		private Collection<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>();
		private Collection<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>();
		private Collection<CreatorDTOImpl> creatorDTOImpls=new ArrayList<CreatorDTOImpl>();
		
		public ArticleDTOImpl build() throws IllegalArgumentException{
			return new ArticleDTOImpl(this);
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
		
		public Builder publicationDate(final Long publicationDate) {
			this.publicationDate=publicationDate;
			return this;
		}
		
		public Builder read(final Boolean read) {
			this.read=read;
			return this;
		}
		
		public Builder archived(final Boolean archived) {
			this.archived=archived;
			return this;
		}
		
		public Builder favorite(final Boolean favorite) {
			this.favorite=favorite;
			return this;
		}
				
		public Builder mediumDTOs(final Collection<MediumDTOImpl> mediumDTOImpls) {
			this.mediumDTOImpls=mediumDTOImpls;
			return this;
		}
		
		public Builder categoryDTOs(final Collection<CategoryDTOImpl> categoryDTOImpls) {
			this.categoryDTOImpls=categoryDTOImpls;
			return this;
		}
		
		public Builder authorDTOs(final Collection<AuthorDTOImpl> authorDTOImpls) {
			this.authorDTOImpls=authorDTOImpls;
			return this;
		}
		
		public Builder creatorDTOs(final Collection<CreatorDTOImpl> creatorDTOImpls) {
			this.creatorDTOImpls=creatorDTOImpls;
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
	public Long getPublicationDate() {
		return publicationDate;
	}

	@Override
	public void setPublicationDate(final Long publicationDate) {
		this.publicationDate=publicationDate;
	}

	@Override
	public Boolean isRead() {
		return read;
	}

	@Override
	public void setRead(final Boolean read) {
		this.read=read;
	}
	
	@Override
	public Boolean getRead(){
		return read;
	}

	@Override
	public Boolean isArchived() {
		return archived;
	}

	@Override
	public void setArchived(final Boolean archived) {
		this.archived=archived;
	}
	
	@Override
	public Boolean getArchived(){
		return archived;
	}

	@Override
	public Boolean isFavorite() {
		return favorite;
	}

	@Override
	public void setFavorite(final Boolean favorite) {
		this.favorite=favorite;
	}
	
	@Override
	public Boolean getFavorite(){
		return favorite;
	}

	@Override
	public Collection<MediumDTOImpl> getMediumDTOs() {
		return mediumDTOImpls;
	}

	@Override
	public void setMediumDTOs(final Collection<MediumDTOImpl> mediumDTOImpls) {
		this.mediumDTOImpls=mediumDTOImpls;
	}
	
	@Override
	public void add(final MediumDTOImpl mediumDTOImpl) {
		if(mediumDTOImpl!=null && !mediumDTOImpls.contains(mediumDTOImpl)) {
			mediumDTOImpls.add(mediumDTOImpl);
		}
	}

	@Override
	public Collection<CategoryDTOImpl> getCategoryDTOs() {
		return categoryDTOImpls;
	}

	@Override
	public void setCategoryDTOs(final Collection<CategoryDTOImpl> categoryDTOImpls) {
		this.categoryDTOImpls=categoryDTOImpls;
	}
	
	@Override
	public void add(final CategoryDTOImpl categoryDTOImpl) {
		if(categoryDTOImpl!=null && !categoryDTOImpls.contains(categoryDTOImpl)) {
			categoryDTOImpls.add(categoryDTOImpl);
		}
	}

	@Override
	public Collection<AuthorDTOImpl> getAuthorDTOs() {
		return authorDTOImpls;
	}

	@Override
	public void setAuthorDTOs(final Collection<AuthorDTOImpl> authorDTOImpls) {
		this.authorDTOImpls=authorDTOImpls;
	}
	
	@Override
	public void add(final AuthorDTOImpl authorDTOImpl) {
		if(authorDTOImpl!=null && !authorDTOImpls.contains(authorDTOImpl)) {
			authorDTOImpls.add(authorDTOImpl);
		}
	}
	
	@Override
	public Collection<CreatorDTOImpl> getCreatorDTOs() {
		return creatorDTOImpls;
	}

	@Override
	public void setCreatorDTOs(final Collection<CreatorDTOImpl> creatorDTOImpls) {
		this.creatorDTOImpls=creatorDTOImpls;
	}
	
	@Override
	public void add(final CreatorDTOImpl creatorDTOImpl) {
		if(creatorDTOImpl!=null && !creatorDTOImpls.contains(creatorDTOImpl)) {
			creatorDTOImpls.add(creatorDTOImpl);
		}
	}
	
	@Override
	public Object clone() {
		final Collection<MediumDTOImpl> clonedMediumDTOImpls=new ArrayList<MediumDTOImpl>();
		for(final MediumDTOImpl mediumDTOImpl : mediumDTOImpls) {
			clonedMediumDTOImpls.add((MediumDTOImpl)mediumDTOImpl.clone());
		}
		final Collection<CategoryDTOImpl> clonedCategoryDTOImpls=new ArrayList<CategoryDTOImpl>();
		for(final CategoryDTOImpl categoryDTOImpl : categoryDTOImpls) {
			clonedCategoryDTOImpls.add((CategoryDTOImpl)categoryDTOImpl.clone());
		}
		final Collection<AuthorDTOImpl> clonedAuthorDTOImpls=new ArrayList<AuthorDTOImpl>();
		for(final AuthorDTOImpl authorDTOImpl : authorDTOImpls) {
			clonedAuthorDTOImpls.add((AuthorDTOImpl)authorDTOImpl.clone());
		}
		final Collection<CreatorDTOImpl> clonedCreatorDTOImpls=new ArrayList<CreatorDTOImpl>();
		for(final CreatorDTOImpl creatorDTOImpl : creatorDTOImpls) {
			clonedCreatorDTOImpls.add((CreatorDTOImpl)creatorDTOImpl.clone());
		}
		return new Builder().id(id).title(title).description(description).link(link).publicationDate(publicationDate)
				.read(read).archived(archived).favorite(favorite)
				.mediumDTOs(clonedMediumDTOImpls).categoryDTOs(clonedCategoryDTOImpls)
				.authorDTOs(clonedAuthorDTOImpls).creatorDTOs(clonedCreatorDTOImpls).build();
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final ArticleDTOImpl articleDTOImpl = (ArticleDTOImpl) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(obj))
				.append(title,articleDTOImpl.getTitle())
				.append(link,articleDTOImpl.getLink())
				.append(description,articleDTOImpl.getDescription())
				.append(publicationDate,articleDTOImpl.getPublicationDate())
				.append(read,articleDTOImpl.getRead())
				.append(archived,articleDTOImpl.getArchived())
				.append(favorite,articleDTOImpl.getFavorite())
                .isEquals()
                && CollectionsUtil.equals(mediumDTOImpls,articleDTOImpl.getMediumDTOs())
                && CollectionsUtil.equals(categoryDTOImpls,articleDTOImpl.getCategoryDTOs())
                && CollectionsUtil.equals(authorDTOImpls,articleDTOImpl.getAuthorDTOs())
                && CollectionsUtil.equals(creatorDTOImpls,articleDTOImpl.getCreatorDTOs());		
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(47,23)
		       .appendSuper(super.hashCode())
		       .append(title)
		       .append(link)
		       .append(description)
		       .append(publicationDate)
		       .append(read)
		       .append(archived)
		       .append(favorite)
		       .append(mediumDTOImpls)
		       .append(categoryDTOImpls)
		       .append(authorDTOImpls)
		       .append(creatorDTOImpls)
		       .toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
			    .append(title)
		        .append(link)
		        .append(description)
		        .append(publicationDate)
		        .append(read)
		        .append(archived)
		        .append(favorite)
		        .append(mediumDTOImpls)
		        .append(categoryDTOImpls)
		        .append(authorDTOImpls)
		        .append(creatorDTOImpls)
				.toString();
	}

}
