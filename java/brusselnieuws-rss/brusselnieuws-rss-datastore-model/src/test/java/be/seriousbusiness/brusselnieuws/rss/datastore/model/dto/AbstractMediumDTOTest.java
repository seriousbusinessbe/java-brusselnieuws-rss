package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Abstract Test Case for MediumDTO implementations.
 * @author stefanborghys
 *
 * @param <DTO> the type of {@link MediumDTO} implementation
 */
public abstract class AbstractMediumDTOTest<DTO extends MediumDTO> implements DTOTest<DTO> {
	private DTO dto;
	private final String link;
	private final MediumTypeDTO mediumTypeDTO;
	private final long size;
	
	/**
	 * Create a new Test Case for MediumDTO implementations.
	 * @param link a valid non <code>null</code> link
	 * @param mediumTypeDTO a valid non <code>null</code> {@link MediumTypeDTO}
	 * @param size a valid size
	 */
	public AbstractMediumDTOTest(final String link,final MediumTypeDTO mediumTypeDTO,final long size){
		this.link=link;
		this.mediumTypeDTO=mediumTypeDTO;
		this.size=size;
	}

	@Override
	public DTO getDTO() {
		return dto;
	}
	
	@Before 
	public void before(){
		dto=create();
	}

	@Test
	@Override
	public void test() {
		assertNull("The link should be null",dto.getLink());
		assertNull("The MediumTypeDTO should be null",dto.getMediumTypeDTO());
		assertNull("The size should be null",dto.getSize());
	}
	
	@Test
	@Override
	public void testGettersAndSetters() {
		dto.setLink(link);
		assertEquals("The retrieved link is not equal to the one set",link,dto.getLink());
		dto.setMediumTypeDTO(mediumTypeDTO);
		assertEquals("The retrieved MediumTypeDTO is not equal to the one set",mediumTypeDTO,dto.getMediumTypeDTO());
		dto.setSize(size);
		assertEquals("The retrieved size is not equal to the one set",size,dto.getSize(),0.0);
	}

}
