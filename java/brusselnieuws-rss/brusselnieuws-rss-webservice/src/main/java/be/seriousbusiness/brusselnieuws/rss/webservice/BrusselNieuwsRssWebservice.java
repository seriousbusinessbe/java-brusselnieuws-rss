package be.seriousbusiness.brusselnieuws.rss.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Brussel Nieuws Rss webservice Spring-boot start-up class.  
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:config/brusselnieuws-rss-webservice-config.xml")
public class BrusselNieuwsRssWebservice {
	
	/**
	 * Starts {@link BrusselNieuwsRssWebservice} using Spring-boot.</br>
	 * Configures and starts an internal Tomcat web server, provided by Spring-boot.</br>
	 * RestController implementations will provide Brussel Nieuws RSS REST services using JSON. 
	 * @param args No arguments required
	 */
	public static void main(final String[] args) {
        SpringApplication.run(BrusselNieuwsRssWebservice.class, args);
    }

}
