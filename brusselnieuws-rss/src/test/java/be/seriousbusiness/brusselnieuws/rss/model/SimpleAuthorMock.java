package be.seriousbusiness.brusselnieuws.rss.model;

public class SimpleAuthorMock implements Author {

	@Override
	public String getName() {
		return "Simple Author Mock";
	}

	@Override
	public Long getId() {
		return 1211109l;
	}

}
