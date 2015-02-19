package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;

/**
 * {@link ArticleDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class ArticleDTOImpl extends AbstractIdDTOImpl<BigInteger> implements ArticleDTO<MediumTypeDTOImpl,MediumDTOImpl,CategoryDTOImpl,AuthorDTOImpl> {
	private String title,link,description;
	private Long publicationDate;
	private Boolean read,archived,favorite;
	private Collection<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>();
	private Collection<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>();
	private Collection<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>();

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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof ArticleDTOImpl && super.equals(obj) &&
				ObjectUtil.isNullOrEqual(title,((ArticleDTOImpl)obj).title) &&
				ObjectUtil.isNullOrEqual(link,((ArticleDTOImpl)obj).link) &&
				ObjectUtil.isNullOrEqual(description,((ArticleDTOImpl)obj).description) &&
				ObjectUtil.isNullOrEqual(publicationDate,((ArticleDTOImpl)obj).publicationDate) &&
				ObjectUtil.isNullOrEqual(read,((ArticleDTOImpl)obj).read) &&
				ObjectUtil.isNullOrEqual(archived,((ArticleDTOImpl)obj).archived) &&
				ObjectUtil.isNullOrEqual(favorite,((ArticleDTOImpl)obj).favorite) &&
				ObjectUtil.isNullOrEqual(mediumDTOImpls,((ArticleDTOImpl)obj).mediumDTOImpls) &&
				ObjectUtil.isNullOrEqual(categoryDTOImpls,((ArticleDTOImpl)obj).categoryDTOImpls) &&
				ObjectUtil.isNullOrEqual(authorDTOImpls,((ArticleDTOImpl)obj).authorDTOImpls);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * 
				ObjectUtil.hashCode(title) * 
				ObjectUtil.hashCode(link) *
				ObjectUtil.hashCode(description) *
				ObjectUtil.hashCode(publicationDate) *
				ObjectUtil.hashCode(read) *
				ObjectUtil.hashCode(archived) *
				ObjectUtil.hashCode(favorite) *
				ObjectUtil.hashCode(mediumDTOImpls) *
				ObjectUtil.hashCode(categoryDTOImpls) *
				ObjectUtil.hashCode(authorDTOImpls);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
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
		final ArticleDTOImpl articleDTOImpl=new ArticleDTOImpl();
		articleDTOImpl.setId(id);
		articleDTOImpl.setTitle(title);
		articleDTOImpl.setDescription(description);
		articleDTOImpl.setLink(link);
		articleDTOImpl.setPublicationDate(publicationDate);
		articleDTOImpl.setRead(read);
		articleDTOImpl.setArchived(archived);
		articleDTOImpl.setFavorite(favorite);
		articleDTOImpl.setMediumDTOs(clonedMediumDTOImpls);
		articleDTOImpl.setCategoryDTOs(clonedCategoryDTOImpls);
		articleDTOImpl.setAuthorDTOs(clonedAuthorDTOImpls);
		return articleDTOImpl;
	}

}
