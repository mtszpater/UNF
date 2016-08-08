package pl.wroc.uni.unf.webservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.wroc.uni.unf.domain.dao.NewsDAO;
import pl.wroc.uni.unf.domain.dao.bean.NewsDAOBean;
import pl.wroc.uni.unf.domain.service.NewsService;
import pl.wroc.uni.unf.domain.service.bean.NewsServiceBean;

/**
 * @author Notechus.
 */
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
@EnableTransactionManagement
public class AppConfig {

	@Value("${server.port}")
	private Integer port;

	@Value("${server.host}")
	private String host;

	@Value("${server.threadpool}")
	private int threadPool;

	@Bean
	public NewsDAO createNewsDAO() {
		return new NewsDAOBean();
	}

	@Bean
	public NewsService createNewsService() {
		return new NewsServiceBean();
	}
}
