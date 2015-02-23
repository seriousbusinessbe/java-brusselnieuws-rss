package be.seriousbusiness.brusselnieuws.rss.webservice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Bla {
	private static final int TOTAL=1024;
	
	public static final int sum(final List<Integer> numbers) {
		int sum=0;
		for(final int number : numbers) {
			sum=sum+number;
		}
		return sum;
	}
	
	public static final int[] push(final int[] numbers,int amount) {
		final int[] forwarded=new int[numbers.length];
		for(int i=amount; i<numbers.length; i++) {
			forwarded[i-amount]=numbers[i];
		}
		for(int i=0; i<amount; i++) {
			forwarded[(numbers.length-amount)+i]=numbers[i];
		}
		return forwarded;
	}
	
	public static final void count(final int[] numbers,final List<Integer> successfullNumbers) {
		for(int i=0; i<numbers.length; i++) {
			final int number=numbers[0];
			final int total=sum(successfullNumbers)+number;
			if(total<=TOTAL) { // Number still in use:
				successfullNumbers.add(number);
				count(numbers,new ArrayList<Integer>(successfullNumbers));
				for(int j=0; j<numbers.length; j++) {
					count(push(numbers,j),new ArrayList<Integer>(successfullNumbers));
				}
			}else if(total==TOTAL) {
				System.out.println(successfullNumbers + " : " + total);
			}
		}		
	}
	
	private static final void assertPush(final int[] numbers,final int amount,final int[] expected) {
		final int[] actual=push(numbers,amount);
		Assert.assertEquals("The length of the result array of numbers is not equal to the one given",numbers.length,actual.length);
		for(int i=0; i<numbers.length; i++) {
			Assert.assertEquals("The numbers are not pushed correctly",expected[i],actual[i]);
		}
	}
	
	@Test
	public void testPush() {
		final int[] numbers=new int[] {57,71,87,97,99,101,103,113,113,114,115,128,128,129,131,137,147,157,163,186};
		int[] expected=new int[] {71,87,97,99,101,103,113,113,114,115,128,128,129,131,137,147,157,163,186,57};		
		assertPush(numbers,1,expected);		
		expected=new int[] {97,99,101,103,113,113,114,115,128,128,129,131,137,147,157,163,186,57,71,87};		
		assertPush(numbers,3,expected);
		
	}
	
	@Test
	public void test() {
		count(new int[] {57,71,87,97,99,101,103,113,113,114,115,128,128,129,131,137,147,157,163,186},new ArrayList<Integer>());
	}

}
