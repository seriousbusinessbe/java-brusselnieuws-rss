package be.seriousbusiness.brusselnieuws.rss.datasource.dao;

public interface IdDAO<DTO,ID> extends DAO<DTO> {
	
	DTO findById(final ID id);

}
