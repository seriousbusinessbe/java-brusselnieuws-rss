package be.seriousbusiness.brusselnieuws.rss.model.impl;

import be.seriousbusiness.brusselnieuws.rss.model.Author;

public class AuthorImpl implements Author {
	private String name;

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return name;
	}

}
