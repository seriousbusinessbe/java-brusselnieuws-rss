package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.util.HashSet;
import java.util.Set;

import be.seriousbusiness.brusselnieuws.rss.model.Manager;

public class ManagerImpl<E> implements Manager<E> {
	private Set<E> entities;
	
	/**
	 * Create a new ManagerImpl without entities.
	 */
	public ManagerImpl(){
		entities=new HashSet<E>();
	}
	
	/**
	 * Create a new AbstractManager containing a set of entities.
	 * @param entities
	 * @throws IllegalArgumentException when the set is or one of its entities is <code>null</code>
	 */
	public ManagerImpl(final Set<E> entities) throws IllegalArgumentException{
		this();
		if(entities==null){
			throw new IllegalArgumentException("The entities set is null");
		}else{
			for(final E e : entities){
				add(e);
			}
		}
	}

	@Override
	public int size() {
		return entities.size();
	}

	@Override
	public void add(final E e) {
		if(e!=null && !entities.contains(e)){
			entities.add(e);
		}
	}

	@Override
	public Set<E> getAll() {
		return new HashSet<E>(entities);
	}

	@Override
	public boolean has(final E e) {
		return entities.contains(e);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof Manager && entities.equals(((Manager<E>)obj).getAll());
	}

}
