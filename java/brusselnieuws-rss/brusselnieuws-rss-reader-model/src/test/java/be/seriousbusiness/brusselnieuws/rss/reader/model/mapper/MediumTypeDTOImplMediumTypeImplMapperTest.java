package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper;

import java.io.IOException;
import java.net.MalformedURLException;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.MediumTypeDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumTypeImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.MediumTypeImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util.MediumTypeDTOMediumTypeMapperUtil;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-reader-model-dozer-config.xml")
public class MediumTypeDTOImplMediumTypeImplMapperTest {
	@Autowired
	private Mapper mapper;
	
	@Test
	public void testMediumTypeDTOImplToMediumTypeImplMapping() throws IOException{
		final MediumTypeDTOImpl mediumTypeDTOImpl=MediumTypeDTOImplFactory.createJPEG();
		final MediumTypeImpl mediumTypeImpl=mapper.map(mediumTypeDTOImpl, MediumTypeImpl.class);
		MediumTypeDTOMediumTypeMapperUtil.assertEquals(mediumTypeDTOImpl, mediumTypeImpl);
	}
	
	@Test
	public void testMediumTypeImplToMediumTypeDTOImplMapping() throws IllegalArgumentException, MalformedURLException{
		final MediumTypeImpl mediumTypeImpl=MediumTypeImplFactory.createJPEG();
		final MediumTypeDTOImpl mediumTypeDTOImpl=mapper.map(mediumTypeImpl,MediumTypeDTOImpl.class);
		MediumTypeDTOMediumTypeMapperUtil.assertEquals(mediumTypeDTOImpl, mediumTypeImpl);
	}

}
