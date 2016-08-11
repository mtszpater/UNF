package pl.wroc.uni.unf.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wroc.uni.unf.domain.entity.News;
import pl.wroc.uni.unf.domain.service.NewsService;
import pl.wroc.uni.unf.domain.to.NewsTO;

import java.util.Date;
import java.util.List;

/**
 * @author pater
 */

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

	@Autowired
	private NewsService newsService;


	public NewsController(NewsService newsService) {

		this.newsService = newsService;
	}

	public NewsController() {
	}

	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<NewsTO>> getNewsForUser(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "token", required = true, defaultValue = "-1") Long userToken) {

		List<NewsTO> news;

		if (username == null) {
			news = newsService.findAll();
		} else {
			news = newsService.findByUser(username);
		}

		return new ResponseEntity<>(news, new HttpHeaders(), HttpStatus.OK);
	}

	@Secured("ROLE_MODERATOR")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> addNews(
			@RequestParam(value = "title", defaultValue = "default") String newsTitle,
			@RequestParam(value = "description", defaultValue = "default") String newsDescription,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {

		newsService.postNews(newsTitle, newsDescription, new Date(), username);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Secured("ROLE_MODERATOR")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<NewsTO> updateNews(
			@RequestParam(value = "title", defaultValue = "default") String newsTitle,
			@RequestParam(value = "description", defaultValue = "default") String newsDescription,
			@RequestParam(value = "id", defaultValue = "0") Long newsId,
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {


		NewsTO newsTO = newsService.findById(newsId);
		News news = new News();
		news.setDescription(newsDescription);
		news.setTitle(newsTitle);
		news.setId(newsId);
//		news.setUser(newsTO.getUsername());


		newsService.updateNews(news);

		return new ResponseEntity<>(newsService.updateNews(news), new HttpHeaders(), HttpStatus.OK);
	}

	@Secured("ROLE_MODERATOR")
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteNews(
			@RequestParam(value = "id", defaultValue = "0") Long newsId,
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {

		newsService.deleteNews(newsId);

		return new ResponseEntity(HttpStatus.OK);
	}


	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<NewsTO> getNewsById(
			@RequestParam(value = "id", defaultValue = "0") Long newsId,
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {

		return new ResponseEntity<>(newsService.findById(newsId), new HttpHeaders(), HttpStatus.OK);
	}
}
