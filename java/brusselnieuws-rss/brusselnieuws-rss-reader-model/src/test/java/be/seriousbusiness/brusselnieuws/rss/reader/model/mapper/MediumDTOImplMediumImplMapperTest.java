package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper;

import java.io.IOException;
import java.net.MalformedURLException;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.MediumDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.MediumImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util.MediumDTOMediumMapperUtil;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brussel-rss-reader-model-dozer-config.xml")
public class MediumDTOImplMediumImplMapperTest {
	@Autowired
	private Mapper mapper;
	
	@Test
	public void testMediumDTOImplToMediumImplMapping() throws IOException{
		final MediumDTOImpl mediumDTOImpl=MediumDTOImplFactory.createJPEGImage();
		final MediumImpl mediumImpl=mapper.map(mediumDTOImpl, MediumImpl.class);
		MediumDTOMediumMapperUtil.assertEquals(mediumDTOImpl, mediumImpl);
	}
	
	@Test
	public void testMediumImplToMediumDTOImplMapping() throws IllegalArgumentException, MalformedURLException{
		final MediumImpl mediumImpl=MediumImplFactory.createJPEG();
		final MediumDTOImpl mediumDTOImpl=mapper.map(mediumImpl,MediumDTOImpl.class);
		MediumDTOMediumMapperUtil.assertEquals(mediumDTOImpl, mediumImpl);
	}

}
