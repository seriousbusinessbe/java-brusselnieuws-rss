package be.seriousbusiness.brusselnieuws.rss.webservice.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger //Loads the spring beans required by the framework
public class BrusselNieuwsSwaggerConfig {
	
	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	/**
	* Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple
	* swagger groups i.e. same code base multiple swagger resource listings.
	*/
	@Bean
	public SwaggerSpringMvcPlugin customImplementation(){
		return new SwaggerSpringMvcPlugin(springSwaggerConfig).includePatterns(".*?");
	}

}
