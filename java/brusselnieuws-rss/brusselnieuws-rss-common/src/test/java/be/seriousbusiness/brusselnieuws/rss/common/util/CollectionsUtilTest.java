package be.seriousbusiness.brusselnieuws.rss.common.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * Test case for {@link CollectionsUtil}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see {@link CollectionsUtil}
 */
public class CollectionsUtilTest {
	
	/**
	 * Tests {@link CollectionsUtil#equals(Collection...)} for the correct result.
	 * @see {@link CollectionsUtil#equals(Collection...)}
	 * @since 1.0
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testEquals() {
		// Test when all arguments are equal:
		assertTrue("No arguments should return true",CollectionsUtil.equals(new Collection[0]));
		assertTrue("A single null argument should return true",CollectionsUtil.equals(new Collection[] {null}));
		assertTrue("Two null arguments should return true",CollectionsUtil.equals(new Collection[] {null,null}));
		final List<Integer> numberList=new ArrayList<Integer>();
		assertTrue("A single empty ArrayList should return true",CollectionsUtil.equals(new Collection[] {numberList}));
		assertTrue("Twice the same ArrayList should return true",CollectionsUtil.equals(new Collection[] {numberList,numberList}));
		numberList.add(1);
		assertTrue("A single one element ArrayList should return true",CollectionsUtil.equals(new Collection[] {numberList}));
		assertTrue("Twice the same ArrayList should return true",CollectionsUtil.equals(new Collection[] {numberList,numberList}));
		numberList.clear();
		numberList.add(null);
		assertTrue("A single one element ArrayList should return true",CollectionsUtil.equals(new Collection[] {numberList}));
		assertTrue("Twice the same ArrayList should return true",CollectionsUtil.equals(new Collection[] {numberList,numberList}));
		numberList.clear();
		numberList.add(1);
		numberList.add(null);
		assertTrue("A single two element ArrayList should return true",CollectionsUtil.equals(new Collection[] {numberList}));
		assertTrue("Twice the same ArrayList should return true",CollectionsUtil.equals(new Collection[] {numberList,numberList}));
		numberList.clear();
		final List<Integer> numberList1=new ArrayList<Integer>(),numberList2=new ArrayList<Integer>();
		assertTrue("Two emtpy ArrayLists should return true",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertTrue("Two emtpy ArrayLists should return true",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
		numberList1.add(1);
		numberList2.add(1);
		assertTrue("Two ArrayLists containing one equal element should return true",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertTrue("Two ArrayLists containing one equal element should return true",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
		numberList1.clear();
		numberList2.clear();
		numberList1.add(1);
		numberList2.add(1);
		numberList1.add(null);
		numberList2.add(null);
		assertTrue("Two ArrayLists containing two equal elements (including null) should return true",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertTrue("Two ArrayLists containing two equal elements (including null) should return true",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
		numberList1.clear();
		numberList2.clear();
		numberList1.add(1);
		numberList2.add(null);
		numberList1.add(null);
		numberList2.add(1);
		assertTrue("Two ArrayLists containing two equal elements (including null) in different order should return true",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertTrue("Two ArrayLists containing two equal elements (including null) in different order should return true",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
		numberList1.clear();
		numberList2.clear();
		numberList1.add(1);
		numberList2.add(null);
		numberList1.add(null);
		numberList2.add(1);
		numberList1.add(2);
		numberList2.add(null);
		numberList1.add(null);
		numberList2.add(2);
		assertTrue("Two ArrayLists containing four equal elements (including null) in different order should return true",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertTrue("Two ArrayLists containing four equal elements (including null) in different order should return true",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
		// Test when all arguments are not equal:
		numberList1.clear();
		numberList2.clear();
		assertFalse("Two emtpy ArrayLists and null should return false",CollectionsUtil.equals(new Collection[] {numberList1,numberList2,null}));
		numberList1.clear();
		numberList2.clear();
		numberList1.add(null);
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
		numberList1.clear();
		numberList2.clear();
		numberList1.add(null);
		numberList2.add(1);
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
		numberList1.clear();
		numberList2.clear();
		numberList1.add(1);
		numberList2.add(1);
		numberList1.add(2);
		numberList2.add(2);
		numberList1.add(3);
		numberList2.add(3);
		numberList2.add(4);
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
		numberList1.clear();
		numberList2.clear();
		numberList1.add(1);
		numberList2.add(1);
		numberList1.add(1);
		numberList2.add(1);
		numberList1.add(1);
		numberList2.add(1);
		numberList2.add(4);
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
		numberList1.clear();
		numberList2.clear();
		numberList1.add(1);
		numberList2.add(1);
		numberList1.add(1);
		numberList2.add(1);
		numberList1.add(1);
		numberList2.add(1);
		numberList2.add(null);
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList1,numberList2}));
		assertFalse("Two ArrayLists containing different elements should return false",CollectionsUtil.equals(new Collection[] {numberList2,numberList1}));
	}

}
