package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.mapping;

import org.junit.Test;

public abstract class AbstractMappingTest<DTO,DTOA extends DTO,DTOB extends DTO> {
	
	/**
	 * Create a new {@Link DTOA} filled with data and ready to be mapped.
	 * @return a new {@Link DTOA}
	 */
	protected abstract DTOA createDTOA();
	
	/**
	 * Create a new {@link DTOB} filled with data and ready to be mapped.
	 * @return a new {@link DTOB}
	 */
	protected abstract DTOB createDTOB();
	
	/**
	 * Map a {@link DTOA} to a new {@link DTOB}.
	 * @param dtoA
	 * @return a new {@link DTOB}.
	 */
	protected abstract DTOB mapToDTOB(final DTOA dtoA);
	
	/**
	 * Map a {@link DTOB} to a new {@link DTOA}.
	 * @param dtoB
	 * @return a new {@link DTOA}
	 */
	protected abstract DTOA mapToDTOA(final DTOB dtoB);
	
	/**
	 * Assert if all data in {@link DTOA} is equal to {@link DTOB}.
	 * @param dtoA
	 * @param dtoB
	 */
	protected abstract void assertEquals(final DTOA dtoA,final DTOB dtoB);
	
	/**
	 * Test mapping an {@link DTOA} to a {@link DTOB}.
	 * By creating a new {@link DTOA} mapping it to {@link DTOB} and asserting it for equality.
	 */
	@Test
	public void testMappingDTOAToDTOB(){
		final DTOA dtoA=createDTOA();
		assertEquals(dtoA,mapToDTOB(dtoA));
	}
	
	/**
	 * Test mapping an {@link DTOB} to a {@link DTOA}.
	 * By creating a new {@link DTOB} mapping it to {@link DTOA} and asserting it for equality.
	 */
	@Test
	public void testMappingDTOBToDTOA(){
		final DTOB dtoB=createDTOB();
		assertEquals(mapToDTOA(dtoB),dtoB);
	}

}
