package be.seriousbusiness.brusselnieuws.rss.common.util;

import java.util.Collection;

import static be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil.equalClass;
import static be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil.equalReference;

/**
 * {@link Collection} utility helper.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see {@link Collection}
 */
public class CollectionsUtil {
	
	/**
	 * Equals {@link Collection}s and their elements without restricting the order of their elements.
	 * @param collections array of Collection(s)
	 * @return <code>true</code> when all collection elements are equal
	 * @since 1.0
	 * @see {@link ObjectUtil#equalReference(Object...)}
	 * @see {@link ObjectUtil#equalClass(Object...)}
	 */
	public static final <T1,T2 extends Collection<T1>> boolean equals(@SuppressWarnings("unchecked") final T2... collections) {
		if(equalReference(collections)) { return true; }
		if(!equalClass(collections)) { return false; }
		// TODO : remove when approved
		//final int size=collections[0].size(),numberOfNull=numberOfNull(collections[0].toArray());
		for(int i=1 ; i<collections.length ; i++) {
			/* TODO : remove when approved
			if(!collections[i].containsAll(collections[0]) ||
					numberOfNull!=numberOfNull(collections[i].toArray()) ||
							size!=collections[i].size()) { return false; }
							*/
			if(!collections[i].containsAll(collections[0]) || collections[0].size()!=collections[i].size()) { return false; }
			/* TODO : remove when approved
			int j=0;
			for(final T1 t1A : collections[i]) {
				for(final T1 t1B : collections[0]) {
					if(t1A!=null && t1B!=null && t1A.equals(t1B)) { j++; break; }
				}
			}
			if((j+numberOfNull)!=size) { return false; }
			*/
		}
		return true;
	}

}
