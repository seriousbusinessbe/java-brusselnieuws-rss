package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

public interface DAOTest<DTO,D extends DAO<DTO>> {
	
	/**
	 * Creates a new {@link D} implementation under test with no values set.
	 * @return a new {@link DTO} implementation
	 */
	D createDAO();
	
	/**
	 * Creates a new {@link DTO} implementation usable to save in the {@link D} under test.
	 * @return a new {@link DTO} implementation
	 */
	DTO createDTO();
	
	/**
	 * Get the {@link D} used under test.
	 * @return the {@link D} used under test
	 */
	D getDAO();
	
	/**
	 * Get the {@link DTO} used under test.
	 * @return the {@link DTO} used under test.
	 */
	DTO getDTO();

}
