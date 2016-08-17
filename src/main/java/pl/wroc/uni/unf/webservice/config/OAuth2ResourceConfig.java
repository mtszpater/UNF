package pl.wroc.uni.unf.webservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Notechus.
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {

	private TokenExtractor tokenExtractor = new BearerTokenExtractor();

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
				addFilterAfter(new OncePerRequestFilter() {
					@Override
					protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
													FilterChain filterChain) throws ServletException, IOException {
						if (tokenExtractor.extract(httpServletRequest) == null) {
							SecurityContextHolder.clearContext();
						}
						filterChain.doFilter(httpServletRequest, httpServletResponse);
					}
				}, AbstractAuthenticationProcessingFilter.class);
		http.csrf().disable();
		http.authorizeRequests().anyRequest().authenticated();
	}

	@Bean
	public AccessTokenConverter accessTokenConverter() {
		return new DefaultAccessTokenConverter();
	}

	@Bean
	public RemoteTokenServices remoteTokenServices(final @Value("${auth.server.url}") String checkTokenUrl,
												   final @Value("${auth.server.clientId}") String clientId,
												   final @Value("${auth.server.clientsecret}") String clientSecret) {
		final RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setCheckTokenEndpointUrl(checkTokenUrl);
		remoteTokenServices.setClientId(clientId);
		remoteTokenServices.setClientSecret(clientSecret);
		remoteTokenServices.setAccessTokenConverter(accessTokenConverter());

		return remoteTokenServices;
	}
}
