package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import org.junit.Test;

/**
 * Describes base {@link DTO} tests.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <DTO> the type of DTO (Data Transfer Object) implementation
 */
public interface DTOTest<DTO> {
	
	/**
	 * Creates a new {@link DTO} implementation under test with no values set.
	 * @return a new {@link DTO} implementation
	 */
	DTO create();
	
	/**
	 * Gets the {@link DTO} under test.
	 * @return the {@link DTO} under test
	 */
	DTO getDTO();
	
	/**
	 * Tests a new {@link DTO} after construction.</br>
	 * All values should be <code>null</code>.
	 */
	@Test 
	void test();
	
	/**
	 * Tests a new {@link DTO} by setting all variables</br>
	 * and verifying if it's getter results are equal.
	 */
	@Test 
	 void testGettersAndSetters();

}
