package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ManagerUtil {
	
	public static final <E> List<E> toOrderedList(final Set<E> entities,final Comparator<E> comparator){
		@SuppressWarnings("unchecked")
		final List<E> orderedList=(List<E>) Arrays.asList(entities.toArray());
		Collections.sort(orderedList,comparator);
		return orderedList;
	}
	
	public static final <E> Set<E> toOrderedSet(final Set<E> entities,final Comparator<E> comparator){
		final Set<E> orderedArticles=new TreeSet<E>(comparator);
		orderedArticles.addAll(entities);
		return orderedArticles;
	}

}
