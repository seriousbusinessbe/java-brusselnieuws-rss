package be.seriousbusiness.brusselnieuws.rss.webservice;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import be.seriousbusiness.brusselnieuws.rss.webservice.controller.FeedMetaEnum;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedMetaListResponse;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedMetaResponse;

/**
 * server.port=0 scans for a free port (using OS natives to prevent clashes)
 * @author stefanborghys
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BrusselNieuwsRssWebservice.class)
@WebIntegrationTest({"server.port=0"}) // ,"management.port=0"
public class BrusselNieuwsRssWebserviceIntegrationTest {
	private RestTemplate restTemplate = new TestRestTemplate();
	
	@Autowired
    private EmbeddedWebApplicationContext container;

    @Value("${local.server.port}")
    private int port;
	
	@Test
	public void testFeedlist() throws RestClientException, URISyntaxException {
		final FeedMetaListResponse feedMetaListResponse=restTemplate.getForObject(new URI("http://localhost:"+port+"/feedlist"),FeedMetaListResponse.class);
		Assert.assertNotNull(feedMetaListResponse);
		final Collection<FeedMetaResponse> feedMetaResponses=feedMetaListResponse.getFeedMetaResponses();
		Assert.assertNotNull(feedMetaResponses);
		Assert.assertFalse(feedMetaResponses.isEmpty());
		Assert.assertEquals(FeedMetaEnum.values().length, feedMetaResponses.size());
	}

}
