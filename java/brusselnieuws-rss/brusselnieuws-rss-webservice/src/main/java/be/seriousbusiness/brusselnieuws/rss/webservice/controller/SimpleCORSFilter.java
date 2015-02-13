package be.seriousbusiness.brusselnieuws.rss.webservice.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Set's up a filter for request responses and configures it's CORS (Cross-origin resource sharing) headers.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see <a href="https://spring.io/guides/gs/rest-service-cors/">https://spring.io/guides/gs/rest-service-cors/</a>
 */
@Component
public class SimpleCORSFilter implements Filter {

	@Override
	public void destroy() {}

	/**
	 * Responds to all requests with certain Access-Control-* headers.</br> 
	 * In this case, the headers are set to allow POST, GET, OPTIONS, or DELETE requests from clients originated from any host.</br> 
	 * The results of a preflight request may be cached for up to 3,600 seconds (1 hour).</br> 
	 * And the request may include an x-requested-with header.
	 */
	@Override
	public void doFilter(final ServletRequest servletRequest,
						 final ServletResponse servletResponse,
						 final FilterChain filterChain) throws IOException, ServletException {
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(final FilterConfig arg0) throws ServletException {}

}
