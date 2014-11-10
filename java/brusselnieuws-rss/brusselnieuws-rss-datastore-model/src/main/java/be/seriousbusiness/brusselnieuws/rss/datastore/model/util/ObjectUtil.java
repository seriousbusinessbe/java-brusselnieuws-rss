package be.seriousbusiness.brusselnieuws.rss.datastore.model.util;

public class ObjectUtil {
	
	/**
	 * Check if all Objects are <code>null</code>.
	 * @param objs
	 * @return
	 */
	public static final boolean isNull(final Object... objs){
		for(final Object obj : objs){
			if(obj!=null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check if all Objects are not <code>null</code>.
	 * @param objs
	 * @return
	 */
	public static final boolean isNotNull(final Object... objs){
		for(final Object obj : objs){
			if(obj==null){
				return false;
			}
		}
		return true;
	}

	/**
	 * Check if both Objects are <code>null</code> or equal.
	 * @param obj1
	 * @param obj2
	 * @return <code>true</code> when both <code>null</code> or equal.
	 */
	public static final boolean isNullOrEqual(final Object obj1,final Object obj2){
		return isNull(obj1,obj2) || (isNotNull(obj1,obj2) && obj1.equals(obj2));
	}
	
	/**
	 * Return a hashCode even when the Object is <code>null</code>.
	 * @param obj
	 * @return
	 */
	public static final int hashCode(final Object obj){
		return obj==null ? 1 : obj.hashCode();
	}
}
