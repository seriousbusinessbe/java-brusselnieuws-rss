package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;

/**
 * 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedDTOImpl extends AbstractIdDTOImpl<BigInteger> implements FeedDTO<MediumTypeDTOImpl,MediumDTOImpl,CategoryDTOImpl,AuthorDTOImpl,ArticleDTOImpl> {
	private String title,link,description;
	private Collection<ArticleDTOImpl> articleDTOImpls;

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

}
