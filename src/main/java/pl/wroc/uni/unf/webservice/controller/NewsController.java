package pl.wroc.uni.unf.webservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wroc.uni.unf.domain.entity.News;



@RestController
@RequestMapping("/api/v1")
public class NewsController {

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public News news(
            @RequestParam(value="id", defaultValue="-1") Long newsId,
            @RequestParam(value="token", defaultValue="-1") Long userToken) {

        News exampleNews = new News();
        exampleNews.setDescription("test");
        exampleNews.setId(newsId);

        return exampleNews;
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public ResponseEntity addNews(
            @RequestParam(value="title", defaultValue="default") String newsTitle,
            @RequestParam(value="description", defaultValue="default") String newsDescription,
            @RequestParam(value="token", defaultValue="-1") Long userToken) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/news", method = RequestMethod.DELETE)
    public ResponseEntity deleteNews(
            @RequestParam(value="id", defaultValue="default") Long newsId,
            @RequestParam(value="token", defaultValue="-1") Long userToken) {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}
