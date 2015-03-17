package be.seriousbusiness.brusselnieuws.rss.common.util;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	 * {@link ObjectUtil#isNull(boolean, Object...)} assertion helper.
	 * @param nill <code>true</code> to assert for <code>null</code> arguments
	 * 			   <code>false</code> when asserting non <code>null</code> arguments 
	 * @see {@link ObjectUtil#isNull(boolean, Object...)}
	 * @since 1.0
	 */
	public static final void assertIsNull(final boolean nill) {
		final int max=100;
		final Object value="test";
		final List<Object> nullList=new ArrayList<Object>();
		// All argument(s) null:
		for(int i=0 ; i<max ; i++) {
			nullList.add(null);
			assertEquals("",nill,ObjectUtil.isNull(nill,nullList.toArray(new Object[nullList.size()])));
		}
		nullList.clear();
		// First argument is a value, all other null:
		nullList.add(value);
		for(int i=0 ; i<max ; i++) {
			nullList.add(null);
			assertEquals("",nill ? !nill : nill,ObjectUtil.isNull(nill,nullList.toArray(new Object[nullList.size()])));
		}
		nullList.clear();
		// All argument(s) null, the last is a value:
		nullList.add(null);
		for(int i=0 ; i<max ; i++) {
			nullList.add(value);
			assertEquals("",nill ? !nill : nill,ObjectUtil.isNull(nill,nullList.toArray(new Object[nullList.size()])));
			nullList.set(i+1,null);
		}
		nullList.clear();
		// All arguments(s) are a value:
		for(int i=0 ; i<max ; i++) {
			nullList.add(value);
			assertEquals("",!nill,ObjectUtil.isNull(nill,nullList.toArray(new Object[nullList.size()])));
		}
		nullList.clear();
	}
	
	/**
	 * Tests {@link ObjectUtil#isNull(boolean, Object...)} for the correct result when nill is <code>true</code> or </code>false</code>
	 * @see {@link #assertIsNull(boolean)}
	 * @see {@link ObjectUtil#isNull(boolean, Object...)}
	 * @since 1.0
	 */
	@Test
	public void testIsNull() {
		assertIsNull(true);
		assertIsNull(false);
	}
	
	/**
	 * {@link ObjectUtil#numberOfNull(boolean, Object...)} assertion helper.
	 * @param nill <code>true</code> to assert for <code>null</code> arguments
	 * 			   <code>false</code> when asserting non <code>null</code> arguments 
	 * @see {@link ObjectUtil#numberOfNull(boolean, Object...)}
	 * @since 1.0
	 */
	public static final void assertNumberOfNull(final boolean nill) {
		final int max=100;
		final Object value="test";
		final List<Object> nullList=new ArrayList<Object>();
		// All argument(s) null:
		for(int i=0 ; i<max ; i++) {
			nullList.add(null);
			assertEquals("",nill ? i+1 : 0,ObjectUtil.numberOfNull(nill,nullList.toArray(new Object[nullList.size()])),0.0);
		}
		nullList.clear();
		// First argument is a value, all other null:
		nullList.add(value);
		for(int i=0 ; i<max ; i++) {
			nullList.add(null);
			assertEquals("",nill ? i+1 : 1,ObjectUtil.numberOfNull(nill,nullList.toArray(new Object[nullList.size()])),0.0);
		}
		nullList.clear();
		// All argument(s) null, the last is a value:
		nullList.add(null);
		for(int i=0 ; i<max ; i++) {
			nullList.add(value);
			assertEquals("",nill ? i+1 : 1,ObjectUtil.numberOfNull(nill,nullList.toArray(new Object[nullList.size()])),0.0);
			nullList.set(i+1,null);
		}
		nullList.clear();
		// All arguments(s) are a value:
		for(int i=0 ; i<max ; i++) {
			nullList.add(value);
			assertEquals("",nill ? 0 : i+1,ObjectUtil.numberOfNull(nill,nullList.toArray(new Object[nullList.size()])),0.0);
		}
		nullList.clear();
	}
	
	/**
	 * Tests {@link ObjectUtil#numberOfNull(boolean, Object...)} for the correct result when nill is <code>true</code> or </code>false</code>
	 * @see {@link #assertNumberOfNull(boolean)}
	 * @see {@link ObjectUtil#numberOfNull(boolean, Object...)}
	 * @since 1.0
	 */
	@Test
	public void testNumberOfNull() {
		assertNumberOfNull(true);
		assertNumberOfNull(false);
	}
	
	/**
	 * Tests {@link ObjectUtil#equalReference(Object...)} for the correct result.
	 * @see {@link ObjectUtil#equalReference(Object...)}
	 * @since 1.0
	 */
	@Test
	public void testEqualReference() {
		final String value="test";
		assertTrue("No argument should return true",ObjectUtil.equalReference(new Object[0]));
		assertTrue("A single argument should return true as it is always referenced to itself",ObjectUtil.equalReference(new Object[] {null}));
		assertTrue("Twice the same argument should return true.",ObjectUtil.equalReference(new Object[] {null,null}));
		assertTrue("A single argument should return true as it is always referenced to itself",ObjectUtil.equalReference(new Object[] {value}));
		assertTrue("Twice the same argument should return true.",ObjectUtil.equalReference(new Object[] {value,value}));
		assertTrue("Three times the same argument should return true.",ObjectUtil.equalReference(new Object[] {value,value,value}));
		assertFalse("Two differenct arguments should return false",ObjectUtil.equalReference(new Object[] {null,value}));
		assertFalse("Two same arguments and one different should return false",ObjectUtil.equalReference(new Object[] {value,null,value}));
	}
	
	/**
	 * Tests {@link ObjectUtil#equalClass(Object...)} for the correct result.
	 * @see {@link ObjectUtil#equalClass(Object...)}
	 * @since 1.0
	 */
	@Test 
	public void testEqualClass() {
		assertTrue("No argument should return true",ObjectUtil.equalClass(new Object[0]));
		assertTrue("A single argument should return true",ObjectUtil.equalClass(new Object[] {null}));
		assertTrue("Two arguments of the same class should return true.",ObjectUtil.equalClass(new Object[] {null,null}));
		assertTrue("A single argument should return true",ObjectUtil.equalClass(new Object[] {"test"}));
		assertTrue("Two arguments of the same class should return true.",ObjectUtil.equalClass(new Object[] {"one","two"}));
		assertTrue("Two arguments of the same class should return true.",ObjectUtil.equalClass(new Object[] {1,2,3}));
		assertTrue("Three arguments of the same class should return true.",ObjectUtil.equalClass(new Object[] {null,null,null}));
		assertTrue("Three arguments of the same class should return true.",ObjectUtil.equalClass(new Object[] {"mi","ma","moe"}));
		assertTrue("Three arguments of the same class should return true.",ObjectUtil.equalClass(new Object[] {0.34,34.88,42.3}));
		assertFalse("Two different classes should return false.",ObjectUtil.equalClass(new Object[] {5.9,"test"}));
		assertFalse("Three arguments with one different class should return false.",ObjectUtil.equalClass(new Object[] {null,null,"test"}));
		assertFalse("Three different classes should return false.",ObjectUtil.equalClass(new Object[] {5.9,null,"test"}));
	}
	
	/**
	 * Tests {@link ObjectUtil#equals(Object...)} for the correct result.
	 * @see {@link ObjectUtil#equals(Object...)}
	 * @since 1.0
	 */
	@Test
	public void testEquals() {
		// Test when all arguments are equal or null:
		assertTrue("No argument should rturn true",ObjectUtil.equals(new Object[0]));
		assertTrue("A single argument should return true",ObjectUtil.equals(new Object[] {null}));
		assertTrue("A single argument should return true",ObjectUtil.equals(new Object[] {"test"}));
		assertTrue("A single argument should return true",ObjectUtil.equals(new Object[] {1}));
		assertTrue("A single argument should return true",ObjectUtil.equals(new Object[] {true}));
		assertTrue("Two null arguments should return true",ObjectUtil.equals(new Object[] {null,null}));
		assertTrue("Two equal String arguments should return true",ObjectUtil.equals(new Object[] {"test","test"}));
		assertTrue("Two equal int arguments should return true",ObjectUtil.equals(new Object[] {1,1}));
		assertTrue("Two equal boolean arguments should return true",ObjectUtil.equals(new Object[] {true,true}));
		assertTrue("Three null arguments should return true",ObjectUtil.equals(new Object[] {null,null,null}));
		assertTrue("Three equal String arguments should return true",ObjectUtil.equals(new Object[] {"test","test","test"}));
		assertTrue("Three equal int arguments should return true",ObjectUtil.equals(new Object[] {1,1,1}));
		assertTrue("Three equal boolean arguments should return true",ObjectUtil.equals(new Object[] {true,true,true}));
		// Test when all arguments are not equal:
		assertFalse("Two non equal arguments should return false",ObjectUtil.equals(new Object[] {null,"test"}));
		assertFalse("Two non equal arguments should return false",ObjectUtil.equals(new Object[] {null,1}));
		assertFalse("Two non equal arguments should return false",ObjectUtil.equals(new Object[] {null,true}));
		assertFalse("Two non equal arguments should return false",ObjectUtil.equals(new Object[] {"test",null}));
		assertFalse("Two non equal arguments should return false",ObjectUtil.equals(new Object[] {1,null}));
		assertFalse("Two non equal arguments should return false",ObjectUtil.equals(new Object[] {true,null}));
		assertFalse("Two non equal String arguments should return true",ObjectUtil.equals(new Object[] {"testa","testb"}));
		assertFalse("Two non equal String arguments should return true",ObjectUtil.equals(new Object[] {"testb","testa"}));
		assertFalse("Two non equal int arguments should return true",ObjectUtil.equals(new Object[] {1,0}));
		assertFalse("Two non equal int arguments should return true",ObjectUtil.equals(new Object[] {0,1}));
		assertFalse("Two non equal boolean arguments should return true",ObjectUtil.equals(new Object[] {true,false}));
		assertFalse("Two non equal boolean arguments should return true",ObjectUtil.equals(new Object[] {false,true}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {null,null,"test"}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {null,"test",null}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {"test",null,null}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {null,null,1}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {null,1,null}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {1,null,null}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {null,null,true}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {null,true,null}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {true,null,null}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {"test","test",null}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {"test",null,"test"}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {null,"test","test"}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {1,1,null}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {1,null,1}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {null,1,1}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {true,true,null}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {true,null,true}));
		assertFalse("Three non equal arguments should return false",ObjectUtil.equals(new Object[] {null,true,true}));		
		assertFalse("Three non equal String arguments should return true",ObjectUtil.equals(new Object[] {"testa","testb","testc"}));
		assertFalse("Three non equal String arguments should return true",ObjectUtil.equals(new Object[] {"testb","testc","testa"}));
		assertFalse("Three non equal String arguments should return true",ObjectUtil.equals(new Object[] {"testc","testa","testb"}));
		assertFalse("Three non equal int arguments should return true",ObjectUtil.equals(new Object[] {0,1,2}));
		assertFalse("Three non equal int arguments should return true",ObjectUtil.equals(new Object[] {1,2,0}));
		assertFalse("Three non equal int arguments should return true",ObjectUtil.equals(new Object[] {2,1,0}));
		assertFalse("Three non equal boolean arguments should return true",ObjectUtil.equals(new Object[] {true,true,false}));
		assertFalse("Three non equal boolean arguments should return true",ObjectUtil.equals(new Object[] {true,false,true}));
		assertFalse("Three non equal boolean arguments should return true",ObjectUtil.equals(new Object[] {false,true,true}));		
	}
	
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
