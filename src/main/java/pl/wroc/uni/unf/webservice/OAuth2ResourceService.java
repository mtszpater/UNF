package pl.wroc.uni.unf.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.wroc.uni.unf.webservice.config.MethodSecurityConfig;
import pl.wroc.uni.unf.webservice.config.OAuth2ResourceConfig;

/**
 * @author Notechus.
 */
@EnableAutoConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@Import({OAuth2ResourceConfig.class, MethodSecurityConfig.class})
@ComponentScan("pl.wroc.uni.unf")
public class OAuth2ResourceService extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {

		SpringApplication.run(OAuth2ResourceService.class, args);
	}
}
