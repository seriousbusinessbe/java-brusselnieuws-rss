package be.seriousbusiness.brusselnieuws.rss.common.util;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link ObjectUtil} test case.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class ObjectUtilTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(ObjectUtilTest.class);
	
	/**
	 * Tests {@link ObjectUtil} toString() method.
	 * @see be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil#toString(Object)
	 */
	@Test
	public void testToString(){
		final String s=ObjectUtil.toString(new TestObject());
		LOGGER.debug("{}",s);
		assertNotNull(s);
		assertFalse(s.isEmpty());
	}

}
