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
import java.util.regex.Matcher;

import static org.junit.Assert.*;

/**
 * author @pater
 */
public class NewsControllerTest {

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


		assertEquals(controller.getNews(null, 0L), new ResponseEntity<>(createListWithNews(), new HttpHeaders(), HttpStatus.OK));

	}

	@Test
	public void shouldReturnListWithOneNewsForUser() throws Exception {
		Mockito.when(newsService.findByUser("user")).thenReturn(createListWithNews());

		NewsController controller = new NewsController(newsService);

		assertEquals(controller.getNews("user", 0L), new ResponseEntity<>(createListWithNews(), new HttpHeaders(), HttpStatus.OK));

	}

	@Test
	public void shouldReturnSuccessAfterPostNews() throws Exception {

		assertEquals(controller.addNews("Title", "Description", "user", 0L), new ResponseEntity(HttpStatus.OK));
	}


	@Test
	public void shouldReturnPostWhileGettingPostById() throws Exception {
		Mockito.when(newsService.findById(0L)).thenReturn(createNewsTO());

		assertEquals(controller.getNewsById(0L, 0L), new ResponseEntity<>(createNewsTO(), new HttpHeaders(), HttpStatus.OK));
	}


	@Test
	public void shouldReturnSuccessAfterUpdateNews() throws Exception {
		Mockito.when(newsService.updateNews(Matchers.anyLong(), Matchers.anyString(), Matchers.anyString())).thenReturn(createNewsTO());

		assertEquals(controller.updateNews("Title", "Description", 0L, 0L), new ResponseEntity<>(createNewsTO(), new HttpHeaders(), HttpStatus.OK));
	}

	@Test
	public void shouldReturnSuccessAfterDeleteNews() throws Exception {

		assertEquals(controller.deleteNews(0L, 0L), new ResponseEntity(HttpStatus.OK));
	}

	private News createNews() {
		News news = new News();
		news.setDescription("Description");
		news.setTitle("Title");

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