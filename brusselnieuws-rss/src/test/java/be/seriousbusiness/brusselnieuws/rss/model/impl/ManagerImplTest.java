package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;

public class ManagerImplTest {
	private Manager<String> manager;
	
	@Before
	public void before(){
		manager=new ManagerImpl<String>();
	}
	
	@Test
	public void testSize(){
		assertEquals("The size should be zero",0,manager.size());
		manager.add("Test");
		assertEquals("The size should be one",1,manager.size());
	}
	
	@Test
	public void testAddNull(){
		assertEquals("The size should be zero",0,manager.size());
		manager.add(null);
		assertEquals("The size should be zero",0,manager.size());
		final Set<String> strings=manager.getAll();
		assertNotNull("The set of strings can never be null",strings);
		assertEquals("The set of strings should be zero",0,strings.size());
	}
	
	@Test
	public void testAdd(){
		final String s="Test";
		assertEquals("The size should be zero",0,manager.size());
		manager.add(s);
		assertEquals("The size should be zero",1,manager.size());
		Set<String> strings=manager.getAll();
		assertNotNull("The set of strings can never be null",strings);
		assertEquals("The set of strings should be zero",1,strings.size());
		List<String> orderedStrings=manager.getAll(new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
			
		});
		assertEquals(s,orderedStrings.get(0));
		manager.add(s);
		assertEquals("The size should be zero",1,manager.size());
		strings=manager.getAll();
		assertNotNull("The set of strings can never be null",strings);
		assertEquals("The set of strings should be zero",1,strings.size());
		orderedStrings=manager.getAll(new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
			
		});
	}
	

}
