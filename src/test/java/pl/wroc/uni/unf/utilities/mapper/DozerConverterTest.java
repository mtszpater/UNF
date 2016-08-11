package pl.wroc.uni.unf.utilities.mapper;

import org.junit.Before;
import org.junit.Test;
import pl.wroc.uni.unf.domain.entity.News;
import pl.wroc.uni.unf.domain.entity.User;
import pl.wroc.uni.unf.domain.to.NewsTO;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Notechus.
 */
public class DozerConverterTest {

	private static final Long ID = 1L;
	private static final String DESCRIPTION = "simple description";
	private static final String TITLE = "title";
	private static final String USERNAME = "unf_dev";
	private static final Date DATE = new Date(1470691194000L);
	private User user = new User();
	private DozerConverter converter = new DozerConverter();

	@Before
	public void setUp() {
		user.setUsername(USERNAME);
	}

	@Test
	public void shouldConvertNewsToNewsTO() {
		NewsTO expectedNewsTO = createNewsTO(ID, TITLE, DESCRIPTION, DATE, USERNAME);
		News news = createNews(ID, TITLE, DESCRIPTION, DATE, USERNAME);

		NewsTO mappedNewsTO = converter.convert(news, NewsTO.class);

		assertEquals(expectedNewsTO, mappedNewsTO);
	}

	private NewsTO createNewsTO(Long id, String title, String description, Date date, String username) {
		return new NewsTO(id, username, title, description, date);
	}

	private News createNews(Long id, String title, String description, Date date, String username) {
		user.setUsername(username);
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setDescription(description);
		news.setUser(user);
		news.setDate(date);

		return news;
	}

}