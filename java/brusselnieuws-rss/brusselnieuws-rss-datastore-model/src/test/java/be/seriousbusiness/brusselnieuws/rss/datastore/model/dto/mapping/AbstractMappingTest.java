package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.mapping;

import org.junit.Test;

/**
 * Abstract DTO mapping test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <DTO> the DTO interface type
 * @param <DTOA> the type of DTO implementation 
 * @param <DTOB> the type of DTO implementation
 */
public abstract class AbstractMappingTest<DTO,DTOA extends DTO,DTOB extends DTO> {
	
	/**
	 * Creates a new {@Link DTOA} filled with data and ready to be mapped.
	 * @return a new {@Link DTOA}
	 */
	protected abstract DTOA createDTOA();
	
	/**
	 * Creates a new {@link DTOB} filled with data and ready to be mapped.
	 * @return a new {@link DTOB}
	 */
	protected abstract DTOB createDTOB();
	
	/**
	 * Maps a {@link DTOA} to a new {@link DTOB}.
	 * @param dtoA
	 * @return a new {@link DTOB}.
	 */
	protected abstract DTOB mapToDTOB(final DTOA dtoA);
	
	/**
	 * Maps a {@link DTOB} to a new {@link DTOA}.
	 * @param dtoB
	 * @return a new {@link DTOA}
	 */
	protected abstract DTOA mapToDTOA(final DTOB dtoB);
	
	/**
	 * Asserts if all data in {@link DTOA} is equal to {@link DTOB}.
	 * @param dtoA
	 * @param dtoB
	 */
	protected abstract void assertEquals(final DTOA dtoA,final DTOB dtoB);
	
	/**
	 * Tests mapping {@link DTOA} to  {@link DTOB}.</br>
	 * By creating a new {@link DTOA} mapping it to {@link DTOB} and asserting it for equality.
	 */
	@Test
	public void testMappingDTOAToDTOB(){
		final DTOA dtoA=createDTOA();
		assertEquals(dtoA,mapToDTOB(dtoA));
	}
	
	/**
	 * Tests mapping {@link DTOB} to a {@link DTOA}.</br>
	 * By creating a new {@link DTOB} mapping it to {@link DTOA} and asserting it for equality.
	 */
	@Test
	public void testMappingDTOBToDTOA(){
		final DTOB dtoB=createDTOB();
		assertEquals(mapToDTOA(dtoB),dtoB);
	}

}
