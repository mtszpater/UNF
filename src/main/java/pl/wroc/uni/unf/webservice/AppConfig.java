package pl.wroc.uni.unf.webservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Notechus.
 */
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
public class AppConfig {

	@Value("${server.port}")
	private Integer port;

	@Value("${server.host}")
	private String host;

	@Value("${server.threadpool}")
	private int threadPool;
}
