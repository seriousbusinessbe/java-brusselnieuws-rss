package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public abstract class AbstractAdaptableContentTest<C extends AdaptableContent> {
	protected C adaptable;
	
	@Rule
	public ExpectedException expectedException=ExpectedException.none();
	
	/**
	 * Creates a new adaptableContent implementation under test,</br>
	 * before every test
	 */
	@Before
	public abstract void before();
	
	/**
	 * Test if setting an <code>null</code> title throws an IllegalArgumentException.
	 */
	@Test
	public void testSetTitleNull(){
		expectedException.expect(IllegalArgumentException.class);
		adaptable.setTitle(null);
	}
	
	/**
	 * Test if setting an empty title throws an IllegalArgumentException.
	 */
	@Test
	public void testSetTitleEmpty(){
		expectedException.expect(IllegalArgumentException.class);
		adaptable.setTitle("");
	}
	
	/**
	 * Test if setting a new title with spaces is trimmed.
	 */
	@Test
	public void testSetTitle(){
		final String title="Title test "+System.currentTimeMillis();
		adaptable.setTitle(" "+title+" ");
		Assert.assertEquals("The title is not trimmed",title,adaptable.getTitle());
	}
	
	/**
	 * Test if setting an <code>null</code> link throws an IllegalArgumentException.
	 */
	@Test
	public void testSetLinkNull(){
		expectedException.expect(IllegalArgumentException.class);
		adaptable.setLink(null);
	}
	
	/**
	 * Test setting a new link
	 * @throws MalformedURLException
	 */
	@Test
	public void testSetLink() throws MalformedURLException{
		final URL url=new URL("http://www.google.be");
		adaptable.setLink(url);
		Assert.assertEquals("The link should be equal",url,adaptable.getLink());
	}
	
	/**
	 * Test if setting an <code>null</code> description throws an IllegalArgumentException.
	 */
	@Test
	public void testSetDescriptionNull(){
		expectedException.expect(IllegalArgumentException.class);
		adaptable.setDescription(null);
	}
	
	/**
	 * Test setting an empty description.
	 */
	@Test
	public void testSetDescriptionEmpty(){
		adaptable.setDescription("");
		Assert.assertEquals("","",adaptable.getDescription());
	}
	
	/**
	 * Test if setting a new description with spaces is trimmed.
	 */
	@Test
	public void testSetDescription(){
		final String description="Description test "+System.currentTimeMillis();
		adaptable.setDescription(" "+description+" ");
		Assert.assertEquals("The description is not trimmed",description,adaptable.getDescription());
	}

}
