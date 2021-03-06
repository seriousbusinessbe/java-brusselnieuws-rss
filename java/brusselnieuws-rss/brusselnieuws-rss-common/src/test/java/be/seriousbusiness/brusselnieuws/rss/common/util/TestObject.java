package be.seriousbusiness.brusselnieuws.rss.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link ObjectUtil} test {@link Object}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class TestObject {
	@SuppressWarnings("unused")
	private static final Logger LOGGER=LoggerFactory.getLogger(TestObject.class);
	public String publicStringField="Public String field value";
	private String privateStringField="Private String field value";
	public boolean publicPrimitiveBooleanField=false;
	private boolean privatePrimitiveBooleanField=true;
	
	public String getPublicStringField() {
		return publicStringField;
	}
	
	public void setPublicStringField(String publicStringField) {
		this.publicStringField = publicStringField;
	}
	
	public String getPrivateStringField() {
		return privateStringField;
	}
	
	public void setPrivateStringField(String privateStringField) {
		this.privateStringField = privateStringField;
	}
	
	public boolean isPublicPrimitiveBooleanField() {
		return publicPrimitiveBooleanField;
	}
	
	public void setPublicPrimitiveBooleanField(boolean publicPrimitiveBooleanField) {
		this.publicPrimitiveBooleanField = publicPrimitiveBooleanField;
	}
	
	public boolean isPrivatePrimitiveBooleanField() {
		return privatePrimitiveBooleanField;
	}
	
	public void setPrivatePrimitiveBooleanField(boolean privatePrimitiveBooleanField) {
		this.privatePrimitiveBooleanField = privatePrimitiveBooleanField;
	}

}
