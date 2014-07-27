package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

import static org.junit.Assert.assertEquals;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.model.Id;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableAuthor;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableCategory;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableMedium;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableAuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableCategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableMediumImpl;

@ContextConfiguration("classpath:test-dozer-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DozerDTOAdaptableMappingTest {
	@Autowired
	private Mapper mapper;
	
	private final <ID,D extends DTO<ID>,I extends Id<ID>> void assertIdMapping(final D dto,final I id){
		mapper.map(dto,id);
		assertEquals("The id is not correctly mapped",dto.getId(),id.getId());
	}
	
	@Test
	public void testCategoryDTOToAdaptableCategoryMapping(){
		final CategoryDTO categoryDTO=new SimpleCategoryDTOMock();
		final AdaptableCategory adaptableCategory=new AdaptableCategoryImpl();
		assertIdMapping(categoryDTO,adaptableCategory);
		assertEquals("The name is not correctly mapped",categoryDTO.getName(),adaptableCategory.getName());
		assertEquals("The link is not correctly mapped",categoryDTO.getLink(),adaptableCategory.getLink().toString());
	}
	
	@Test
	public void testAuthorDTOToAdaptableAuthorMapping(){
		final AuthorDTO authorDTO=new SimpleAuthorDTOMock();
		final AdaptableAuthor adaptableAuthor=new AdaptableAuthorImpl();
		assertIdMapping(authorDTO,adaptableAuthor);
		assertEquals("The name is not correctly mapped",authorDTO.getName(),adaptableAuthor.getName());
	}
	
	@Test
	public void testMediumDTOToAdaptableMediumMapping(){
		final MediumDTO mediumDTO=new SimpleMediumDTOMock();
		final AdaptableMedium adaptableMedium=new AdaptableMediumImpl();
		mapper.map(mediumDTO,adaptableMedium);
		assertEquals("The link is not correctly mapped",mediumDTO.getLink(),adaptableMedium.getLink().toString());
		assertEquals("The size is not correctly mapped",mediumDTO.getSize(),adaptableMedium.getSize(),0.0);
		assertEquals("The medium type is not correctly mapped",MediumType.find(mediumDTO.getMediumTypeDTO().getType()),adaptableMedium.getType());
	}

}
