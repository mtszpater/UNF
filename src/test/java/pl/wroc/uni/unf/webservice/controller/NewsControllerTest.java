package pl.wroc.uni.unf.webservice.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.wroc.uni.unf.domain.entity.News;
import pl.wroc.uni.unf.domain.service.NewsService;
import pl.wroc.uni.unf.domain.service.bean.NewsServiceBean;
import pl.wroc.uni.unf.domain.to.NewsTO;
import pl.wroc.uni.unf.utilities.mapper.DozerConverter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * author @pater
 */
public class NewsControllerTest {

	private static final Long TOKEN = 1L;
	private static final String USERNAME = "unf_dev";
	private static final Long NEWS_ID = 0L;
	private static final String DESCRIPTION = "Description";
	private static final String TITLE = "Title";


	@Mock
	private NewsService newsService = Mockito.mock(NewsServiceBean.class);

	private NewsController controller;

	@Before
	public void setUp() {
		controller = new NewsController(newsService);
	}

	@Test
	public void shouldReturnListWithOneNews() throws Exception {
		Mockito.when(newsService.findAll()).thenReturn(createListWithNews());

		assertEquals(controller.getNews(null, TOKEN), new ResponseEntity<>(createListWithNews(), new HttpHeaders(), HttpStatus.OK));

	}

	@Test
	public void shouldReturnListWithOneNewsForUser() throws Exception {
		Mockito.when(newsService.findByUser(USERNAME)).thenReturn(createListWithNews());

		NewsController controller = new NewsController(newsService);

		assertEquals(controller.getNews(USERNAME, TOKEN), new ResponseEntity<>(createListWithNews(), new HttpHeaders(), HttpStatus.OK));

	}

	@Test
	public void shouldReturnSuccessAfterPostNews() throws Exception {

		assertEquals(controller.addNews(TITLE, DESCRIPTION, USERNAME, TOKEN), new ResponseEntity(HttpStatus.OK));
	}


	@Test
	public void shouldReturnPostWhileGettingPostById() throws Exception {
		Mockito.when(newsService.findById(NEWS_ID)).thenReturn(createNewsTO());

		assertEquals(controller.getNewsById(NEWS_ID, TOKEN), new ResponseEntity<>(createNewsTO(), new HttpHeaders(), HttpStatus.OK));
	}


	@Test
	public void shouldReturnSuccessAfterUpdateNews() throws Exception {
		Mockito.when(newsService.updateNews(Matchers.anyLong(), Matchers.anyString(), Matchers.anyString())).thenReturn(createNewsTO());

		assertEquals(controller.updateNews(TITLE, DESCRIPTION, NEWS_ID, TOKEN), new ResponseEntity<>(createNewsTO(), new HttpHeaders(), HttpStatus.OK));
	}

	@Test
	public void shouldReturnSuccessAfterDeleteNews() throws Exception {

		assertEquals(controller.deleteNews(NEWS_ID, TOKEN), new ResponseEntity(HttpStatus.OK));
	}

	private News createNews() {
		News news = new News();
		news.setDescription(DESCRIPTION);
		news.setTitle(TITLE);

		return news;
	}

	private NewsTO createNewsTO() {
		DozerConverter converter = new DozerConverter();
		NewsTO mappedNewsTO = converter.convert(createNews(), NewsTO.class);

		return mappedNewsTO;
	}

	private List<NewsTO> createListWithNews() {
		List<NewsTO> listNews = new ArrayList<>();
		listNews.add(createNewsTO());
		listNews.add(createNewsTO());

		return listNews;
	}
}