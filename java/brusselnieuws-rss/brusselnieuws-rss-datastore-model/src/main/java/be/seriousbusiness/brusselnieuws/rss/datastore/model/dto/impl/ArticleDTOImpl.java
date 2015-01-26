package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
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
	private Collection<MediumDTOImpl> mediumDTOImpls;
	private Collection<CategoryDTOImpl> categoryDTOImpls;
	private Collection<AuthorDTOImpl> authorDTOImpls;

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
	public Collection<CategoryDTOImpl> getCategoryDTOs() {
		return categoryDTOImpls;
	}

	@Override
	public void setCategoryDTOs(final Collection<CategoryDTOImpl> categoryDTOImpls) {
		this.categoryDTOImpls=categoryDTOImpls;
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

}
