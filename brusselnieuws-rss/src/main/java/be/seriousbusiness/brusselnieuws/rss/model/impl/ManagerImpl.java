package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.util.HashSet;
import java.util.Set;

import be.seriousbusiness.brusselnieuws.rss.model.Manager;

public class ManagerImpl<E> implements Manager<E> {
	private int size;
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
	public int getSize() {
		return size;
	}

	protected void add(final E e) throws IllegalArgumentException {
		if(e==null){
			throw new IllegalArgumentException("The entity is null");
		}else if(!entities.contains(e)){
			entities.add(e);
		}
	}

	@Override
	public Set<E> getAll() {
		return new HashSet<E>(entities);
	}

}
