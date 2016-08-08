package pl.wroc.uni.unf.domain.service.bean;

import org.springframework.beans.factory.annotation.Autowired;
import pl.wroc.uni.unf.domain.dao.NewsDAO;
import pl.wroc.uni.unf.domain.entity.News;
import pl.wroc.uni.unf.domain.entity.User;
import pl.wroc.uni.unf.domain.service.NewsService;
import pl.wroc.uni.unf.domain.to.NewsTO;
import pl.wroc.uni.unf.utilities.mapper.ObjectMapper;

import java.util.Date;
import java.util.List;

/**
 * @author Notechus.
 */
public class NewsServiceBean implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	@Override
	public void postNews(String title, String description, Date date, Integer duration, String place, Integer userId) {
		// user_id is temporary i promise
		User user = new User();
		user.setUsername("mpater");
		user.setPassword("2bb80d537b1da3e38bd30361aa855686bde0eacd7162fef6a25fe97bf527a25b");
		user.setEmail("mpater@unf.uni.wroc.pl");
		user.setId(11L);
		// TEMPORARY HACK
		News news = new News();
		news.setTitle(title);
		news.setDescription(description);
		news.setDate(date);
		news.setDuration(duration);
		news.setPlace(place);
		news.setUser(user);
		newsDAO.create(news);
	}

	@Override
	public NewsTO updateNews(News news) {
		News updated = newsDAO.update(news);
		return null;
	}

	@Override
	public List<NewsTO> findAll() {
		List<News> newsList = newsDAO.findAll();
		List<NewsTO> newsTOs = (List<NewsTO>) ObjectMapper.getInstance().getDozerConverter().convertList(newsList, NewsTO.class);
		return newsTOs;
	}

	@Override
	public List<NewsTO> findByUser(String username) {
		List<News> newsList = newsDAO.findByUser(username);
		return null;
	}

	@Override
	public List<NewsTO> findByPlace(String place) {
		List<News> newsList = newsDAO.findByPlace(place);
		return null;
	}

	@Override
	public List<NewsTO> findByDate(Date date) {
		List<News> newsList = newsDAO.findByDate(date);

		return null;
	}
}