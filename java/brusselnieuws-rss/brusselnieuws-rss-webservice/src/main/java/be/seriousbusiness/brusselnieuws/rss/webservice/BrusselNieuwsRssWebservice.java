package be.seriousbusiness.brusselnieuws.rss.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
@EnableAutoConfiguration
public class BrusselNieuwsRssWebservice {
	
	public static void main(final String[] args) {
		//final ApplicationContext context = 
		new ClassPathXmlApplicationContext("classpath:config/brusselnieuws-rss-webservice-config.xml");
        SpringApplication.run(BrusselNieuwsRssWebservice.class, args);
    }

}
