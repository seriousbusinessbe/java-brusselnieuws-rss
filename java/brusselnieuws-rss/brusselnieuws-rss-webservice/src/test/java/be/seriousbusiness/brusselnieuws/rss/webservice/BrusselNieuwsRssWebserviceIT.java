package be.seriousbusiness.brusselnieuws.rss.webservice;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import be.seriousbusiness.brusselnieuws.rss.webservice.controller.FeedMetaEnum;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedMetaListResponse;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedMetaResponse;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedResponse;

/**
 * Brussel Nieuws Rss webservice integration tests case.</br>
 * Make sure the correct MongoDB is up and running!</br>
 * server.port=0 scans for a free port (using OS natives to prevent clashes)
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BrusselNieuwsRssWebservice.class)
@WebIntegrationTest({"server.port=0"}) // ,"management.port=0"
public class BrusselNieuwsRssWebserviceIT {
	private RestTemplate restTemplate;
	private String baseURL;
	
	@Autowired
    private EmbeddedWebApplicationContext container;

    @Value("${local.server.port}")
    private int port;
    
    @Before
    public void before() {
    	restTemplate = new TestRestTemplate();
    	baseURL="http://localhost:"+port+"/";
    }
	
	@Test
	public void testFeedlist() throws RestClientException, URISyntaxException {
		final FeedMetaListResponse feedMetaListResponse=restTemplate.getForObject(new URI(baseURL+"feedlist"),FeedMetaListResponse.class);
		Assert.assertNotNull(feedMetaListResponse);
		final Collection<FeedMetaResponse> feedMetaResponses=feedMetaListResponse.getFeedMetaResponses();
		Assert.assertNotNull(feedMetaResponses);
		Assert.assertFalse(feedMetaResponses.isEmpty());
		Assert.assertEquals(FeedMetaEnum.values().length, feedMetaResponses.size());
		for(final FeedMetaResponse feedMetaResponse : feedMetaResponses) {
			Assert.assertNotNull(FeedMetaEnum.find(feedMetaResponse.getRequestId()));
		}
	}
	
	@Test
	public void testFeedlistStatus() throws RestClientException, URISyntaxException {
		final ResponseEntity<FeedMetaListResponse> feedMetaListResponse=restTemplate.getForEntity(new URI(baseURL+"feedlist"),FeedMetaListResponse.class);
		Assert.assertEquals(HttpStatus.OK,feedMetaListResponse.getStatusCode());
	}
	
	@Test
	public void testFeedStatus() throws RestClientException, URISyntaxException {
		ResponseEntity<FeedResponse> feedResponse=restTemplate.getForEntity(new URI(baseURL+"feed/{id}") ,FeedResponse.class);
		Assert.assertEquals(HttpStatus.OK,feedResponse.getStatusCode());
		for(final FeedMetaEnum feedMetaEnum : FeedMetaEnum.values()) {
			final Map<String,Integer> urlVariables=new HashMap<String,Integer>();
			urlVariables.put("id", feedMetaEnum.getRequestId());
			feedResponse=restTemplate.getForEntity(baseURL+"feed",FeedResponse.class,urlVariables);
			Assert.assertEquals(HttpStatus.OK,feedResponse.getStatusCode());
		}
	}

}
