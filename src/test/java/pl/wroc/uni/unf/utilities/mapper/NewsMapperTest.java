package pl.wroc.uni.unf.utilities.mapper;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import pl.wroc.uni.unf.domain.entity.News;
import pl.wroc.uni.unf.domain.entity.User;
import pl.wroc.uni.unf.domain.to.NewsTO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Notechus.
 */
public class NewsMapperTest {

	private static final Long ID = 1L;
	private static final Long ID_1 = -1L;
	private static final String DESCRIPTION = "simple description";
	private static final String DESCRIPTION_1 = "not the simpliest description";
	private static final String TITLE = "title";
	private static final String TITLE_1 = "not the best title";
	private static final String USERNAME = "unf_dev";
	private static final String USERNAME_1 = "definitely_not_unf_dev";
	private static final Date DATE = new Date(1470691194000L);
	private User user = new User();
	private User user1 = new User();
	private DozerConverter converter = new DozerConverter();

	@Before
	public void setUp() {
		user.setUsername(USERNAME);
		user1.setUsername(USERNAME_1);
	}

	@Test
	public void shouldConvertNewsToNewsTO() {
		NewsTO expectedNewsTO = createNewsTO(ID, TITLE, DESCRIPTION, DATE, USERNAME);
		News news = createNews(ID, TITLE, DESCRIPTION, DATE, user);

		NewsTO mappedNewsTO = converter.convert(news, NewsTO.class);

		assertEquals(expectedNewsTO, mappedNewsTO);
	}

	@Test
	public void shouldConvertNewsListToNewsTOList() {
		List<NewsTO> expectedNewsTO = createNewsTOList();
		List<News> newsList = createNewsList();

		List<NewsTO> mappedNewsTO = converter.convertList(newsList, NewsTO.class);

		Assertions.assertThat(mappedNewsTO).containsOnlyElementsOf(expectedNewsTO);
	}

	private List<NewsTO> createNewsTOList() {
		NewsTO news1 = createNewsTO(ID, TITLE, DESCRIPTION, DATE, USERNAME);
		NewsTO news2 = createNewsTO(ID_1, TITLE_1, DESCRIPTION_1, DATE, USERNAME_1);

		return Arrays.asList(news1, news2);
	}

	private List<News> createNewsList() {
		News news1 = createNews(ID, TITLE, DESCRIPTION, DATE, user);
		News news2 = createNews(ID_1, TITLE_1, DESCRIPTION_1, DATE, user1);

		return Arrays.asList(news1, news2);
	}

	private NewsTO createNewsTO(Long id, String title, String description, Date date, String username) {
		return new NewsTO(id, username, title, description, date);
	}

	private News createNews(Long id, String title, String description, Date date, User user) {
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setDescription(description);
		news.setUser(user);
		news.setDate(date);

		return news;
	}

}