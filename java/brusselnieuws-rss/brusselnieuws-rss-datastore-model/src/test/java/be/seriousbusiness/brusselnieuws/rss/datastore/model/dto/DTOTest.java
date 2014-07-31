package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import org.junit.Test;

/**
 * Defines {@link DTO} base tests.
 * @author stefanborghys
 *
 * @param <DTO> a type of DTO (Data Transfer Object) implementation
 */
public interface DTOTest<DTO> {
	
	/**
	 * Creates a new {@link DTO} implementation under test with no values set.
	 * @return a new {@link DTO} implementation
	 */
	DTO create();
	
	/**
	 * Get the {@link DTO} under test.
	 * @return the {@link DTO} under test
	 */
	DTO getDTO();
	
	/**
	 * Test a new {@link DTO} after construction.</br>
	 * All values should be <code>null</code>.
	 */
	@Test void test();
	
	/**
	 * Test a new {@link DTO} by setting all variables</br>
	 * and verifying if it's getter results are equal.
	 */
	@Test void testGettersAndSetters();

}
