package pl.wroc.uni.unf.webservice.controller;

import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.wroc.uni.unf.domain.service.NewsService;
import pl.wroc.uni.unf.domain.service.bean.NewsServiceBean;
import pl.wroc.uni.unf.domain.to.NewsTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * author @pater
 *
 */
public class NewsControllerTest {

    @Mock
    private NewsService newsService = Mockito.mock(NewsServiceBean.class);


    private NewsTO createNews()
    {
        NewsTO news = new NewsTO();
        news.setDescription("Description");
        news.setTitle("Title");

        return news;
    }

    private List<NewsTO> createListWithNews()
    {
        List<NewsTO> listNews = new ArrayList<>();
        listNews.add(createNews());
        listNews.add(createNews());

        return listNews;
    }

    @Test
    public void ShouldReturnListWithOneNews() throws Exception {

        Mockito.when(newsService.findAll()).thenReturn(createListWithNews());

        NewsController controller = new NewsController(newsService);

        assertEquals(controller.getNewsForUser(null, 0L), new ResponseEntity<>(createListWithNews(), new HttpHeaders(), HttpStatus.OK));

    }

    @Test
    public void ShouldNotReturnAnyNews() throws Exception {

        Mockito.when(newsService.findAll()).thenReturn(new ArrayList<NewsTO>());

        NewsController controller = new NewsController(newsService);

        assertEquals(controller.getNewsForUser(null, 0L), new ResponseEntity<>(new ArrayList<NewsTO>(), new HttpHeaders(), HttpStatus.OK));

    }

    @Test
    public void ShouldReturnListWithOneNewsForUser() throws Exception {

        Mockito.when(newsService.findByUser("user")).thenReturn(createListWithNews());

        NewsController controller = new NewsController(newsService);

        assertEquals(controller.getNewsForUser("user", 0L), new ResponseEntity<>(createListWithNews(), new HttpHeaders(), HttpStatus.OK));

    }

    @Test
    public void ShouldNotReturnAnyNewsForUser() throws Exception {

        Mockito.when(newsService.findByUser("user")).thenReturn(new ArrayList<NewsTO>());

        NewsController controller = new NewsController(newsService);

        assertEquals(controller.getNewsForUser("user", 0L), new ResponseEntity<>(new ArrayList<NewsTO>(), new HttpHeaders(), HttpStatus.OK));

    }

    @Test
    public void ShouldReturnSuccessAfterPostNews() throws Exception {

        NewsController controller = new NewsController();

        assertEquals(controller.addNews("Title", "Description", 0L), new ResponseEntity(HttpStatus.OK));

    }



//    Need method : newsService.findById
//    @Test
//    public void ShouldReturnSuccessAfterDeleteNews() throws Exception {
//
//        Mockito.when(newsService.findByUser("usr")).thenReturn(new ArrayList<NewsTO>());
//
//        NewsController controller = new NewsController(newsService);
//
//        assertEquals(controller.deleteNews(0L, 0L), new ResponseEntity(HttpStatus.OK));
//
//    }



//    @Test
//    public void ShouldReturnSuccessAfterDeleteNews() throws Exception {
//
//        Mockito.when(newsService.findByUser("usr")).thenReturn(new ArrayList<NewsTO>());
//
//        NewsController controller = new NewsController(newsService);
//
//        assertEquals(controller.deleteNews(0L, 0L), new ResponseEntity(HttpStatus.OK));
//
//    }




    @Test
    public void ShouldReturnSuccessAfterAddNews() throws Exception {
        /*
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("http://localhost:8080/api/koty/1", news.class);
        */

        NewsController controller = new NewsController();

        assertEquals(controller.addNews("Title", "Description", 0L), new ResponseEntity(HttpStatus.OK));

    }

//    @Test
//    public void ShouldReturnBadRequestWhileGettingPostById() throws Exception {
//
//        NewsController controller = new NewsController();
//
//        assertEquals(controller.getPostById(-1, 0L), new ResponseEntity(HttpStatus.BAD_REQUEST));
//    }
//
//    @Test
//    public void ShouldReturnBadRequestWhileDeletingNews() throws Exception {
//
//        NewsController controller = new NewsController();
//
//        assertEquals(controller.deleteNews(0L, 0L), new ResponseEntity(HttpStatus.BAD_REQUEST));
//
//    }



}