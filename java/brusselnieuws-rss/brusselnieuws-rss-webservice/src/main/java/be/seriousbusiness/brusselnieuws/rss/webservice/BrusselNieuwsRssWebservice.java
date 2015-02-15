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
 * @see Spring-boot reference: <a href="http://docs.spring.io/spring-boot/docs/current/reference/">http://docs.spring.io/spring-boot/docs/current/reference/</a></br>
 * @see Spring-boot example: Building a RESTful Web Service - <a href="http://spring.io/guides/gs/rest-service/">http://spring.io/guides/gs/rest-service/</a></br>
 * @see Spring-boot example: Building an Application with Spring Boot - <a href="http://spring.io/guides/gs/spring-boot/">http://spring.io/guides/gs/spring-boot/</a></br>
 * </br>
 * Management services provided by Spring Boot (available by adding 'spring-boot-starter-actuator' dependency):</br>
 * <ul>
 * 	<li>health: <a href="http://localhost:8080/health">http://localhost:8080/health</a></li>
 * 	<li>environment: <a href="http://localhost:8080/env">http://localhost:8080/env</a></li>
 * 	<li>beans: <a href="http://localhost:8080/beans">http://localhost:8080/beans</a></li>
 * 	<li>info: <a href="http://localhost:8080/info">http://localhost:8080/info</a></li>
 * 	<li>metrics: <a href="http://localhost:8080/metrics">http://localhost:8080/metrics</a></li>
 * 	<li>trace: <a href="http://localhost:8080/trace">http://localhost:8080/trace</a></li>
 * 	<li>configuration properties: <a href="http://localhost:8080/configprops">http://localhost:8080/configprops</a></li>
 * 	<li>dump: <a href="http://localhost:8080/dump">http://localhost:8080/dump</a></li>
 *  <li>shutdown: <a href="http://localhost:8080/shutdown">http://localhost:8080/shutdown</a>
 *  	<p>Enable 'shutdown' by setting property 'endpoints.shutdown.enabled=true' to <code>true</code> in application.properties which can be found in the resources folder.</p>
 *  </li>
 * </ul>
 * </br>
 * More detailed info about these REST points and there configuration can be found at:</br>
 * <a href="http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints">http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints</a>
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
