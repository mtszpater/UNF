package pl.wroc.uni.unf.utilities.mapper;

import org.junit.Test;
import pl.wroc.uni.unf.domain.entity.News;
import pl.wroc.uni.unf.domain.to.NewsTO;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Notechus.
 */
public class DozerConverterTest {

	private static final String DESCRIPTION = "simple description";
	private static final String TITLE = "title";
	private static final Date DATE = new Date(1470691194);
	private static final Integer DURATION = 1;
	private static final String PLACE = "GRUNWALD";
	private DozerConverter converter = new DozerConverter();

	@Test
	public void shouldConvertNewsToNewsTO() {
		NewsTO expectedNewsTO = createNewsTO(TITLE, DESCRIPTION, DATE, DURATION, PLACE);
		News news = createNews(TITLE, DESCRIPTION, DATE, DURATION, PLACE);

		NewsTO mappedNewsTO = (NewsTO) converter.convert(news, NewsTO.class);

		assertEquals(expectedNewsTO, mappedNewsTO);
	}

	private NewsTO createNewsTO(String title, String description, Date date, Integer duration, String place) {
		return new NewsTO(title, description, date, duration, place);
	}

	private News createNews(String title, String description, Date date, Integer duration, String place) {
		News news = new News();
		news.setTitle(title);
		news.setDescription(description);
		news.setDate(date);
		news.setDuration(duration);
		news.setPlace(place);

		return news;
	}

}