package pl.wroc.uni.unf.webservice.controller;

import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.wroc.uni.unf.domain.service.NewsService;
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
    private NewsService newsService;


    @Test
    public void ShouldReturnListWithOneNews() throws Exception {


        NewsTO news = new NewsTO();
        news.setDescription("Description");
        news.setTitle("Title");

        List<NewsTO> listNews = new ArrayList<>();
        listNews.add(news);

        Mockito.when(newsService.findAll()).thenReturn(listNews);

        NewsController controller = new NewsController(newsService);

        assertEquals(controller.getNewsForUser(null, 0L), listNews);


    }

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