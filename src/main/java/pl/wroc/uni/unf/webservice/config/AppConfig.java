package pl.wroc.uni.unf.webservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.wroc.uni.unf.domain.dao.NewsDAO;
import pl.wroc.uni.unf.domain.dao.UserDAO;
import pl.wroc.uni.unf.domain.dao.bean.NewsDAOBean;
import pl.wroc.uni.unf.domain.dao.bean.UserDAOBean;
import pl.wroc.uni.unf.domain.service.NewsService;
import pl.wroc.uni.unf.domain.service.UserService;
import pl.wroc.uni.unf.domain.service.bean.NewsServiceBean;
import pl.wroc.uni.unf.domain.service.bean.UserServiceBean;

/**
 * @author Notechus.
 */
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
@EnableWebMvc
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

	@Bean
	public UserDAO createUserDAO() {
		return new UserDAOBean();
	}

	@Bean
	public UserService createUserService() {
		return new UserServiceBean();
	}
}
