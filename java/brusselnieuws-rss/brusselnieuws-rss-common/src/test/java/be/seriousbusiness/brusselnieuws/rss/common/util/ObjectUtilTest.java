package be.seriousbusiness.brusselnieuws.rss.common.util;


import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectUtilTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(ObjectUtilTest.class);
	
	@Test
	public void testToString(){
		final String s=ObjectUtil.toString(new TestObject());
		LOGGER.debug("{}",s);
		Assert.assertNotNull(s);
		Assert.assertFalse(s.isEmpty());
	}

}
