package be.seriousbusiness.brusselnieuws.rss.model;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(value=Parameterized.class) 
public class MediumTypeTest {
	private final String type;
	private final MediumType expectedMediumType;
	
	public MediumTypeTest(final String type,final MediumType expectedMediumType){
		this.type=type;
		this.expectedMediumType=expectedMediumType;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters(){
		final Collection<Object[]> parameters=new ArrayList<Object[]>();
		parameters.add(new Object[]{null,MediumType.UNKNOWN}); 
		parameters.add(new Object[]{"",MediumType.UNKNOWN}); 
		parameters.add(new Object[]{"test",MediumType.UNKNOWN}); 
		parameters.add(new Object[]{"image/jpeg",MediumType.IMAGE_JPEG}); 
		return parameters;
	}
	
	/**
	 * Tests if the MediumType.find("type") method returns a correct enumeration.</br>
	 * This test checks <code>null</code>, empty, "test", "image/jpeg" values.
	 */
	@Test
	public void testMediumTypeFind(){
		MediumType mediumType=MediumType.find(type);
		assertNotNull("The medium type cannot be null",mediumType);
		assertEquals("The medium type is not as expected",expectedMediumType,mediumType);
	}

}
