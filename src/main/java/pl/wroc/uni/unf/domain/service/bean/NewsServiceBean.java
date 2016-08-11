package pl.wroc.uni.unf.domain.service.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wroc.uni.unf.domain.dao.NewsDAO;
import pl.wroc.uni.unf.domain.dao.UserDAO;
import pl.wroc.uni.unf.domain.entity.News;
import pl.wroc.uni.unf.domain.entity.User;
import pl.wroc.uni.unf.domain.service.NewsService;
import pl.wroc.uni.unf.domain.to.NewsTO;
import pl.wroc.uni.unf.utilities.mapper.ObjectMapper;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author Notechus.
 */
@Transactional
@Service("newsService")
public class NewsServiceBean implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	@Autowired
	private UserDAO userDAO;

	@Override
	public void postNews(String title, String description, Date date, String username) {
		User user = userDAO.find(username);

		News news = new News();
		news.setTitle(title);
		news.setDescription(description);
		news.setDate(date);
		news.setUser(user);
		newsDAO.create(news);
	}

	@Override
	public NewsTO updateNews(News news) {
		News updated = newsDAO.update(news);
		return ObjectMapper.getInstance().getDozerConverter().convert(updated, NewsTO.class);
	}

	@Override
	public NewsTO updateNews(Long id, String title, String description) {
		News news = newsDAO.find(id);
		news.setTitle(title);
		news.setDescription(description);
		news.setDate(new Date()); // temporary - we will decide later if it stays

		return ObjectMapper.getInstance().getDozerConverter().convert(news, NewsTO.class);
	}

	@Override
	public void deleteNews(Long id) {
		newsDAO.delete(id);
	}

	@Override
	public List<NewsTO> findAll() {
		List<News> newsList = newsDAO.findAll();

		return ObjectMapper.getInstance().getDozerConverter().convertList(newsList, NewsTO.class);
	}

	@Override
	public List<NewsTO> findByUser(String username) {
		List<News> newsList = newsDAO.findByUser(username);

		return ObjectMapper.getInstance().getDozerConverter().convertList(newsList, NewsTO.class);
	}

	@Override
	public List<NewsTO> findByDate(Date date) {
		List<News> newsList = newsDAO.findByDate(date);

		return ObjectMapper.getInstance().getDozerConverter().convertList(newsList, NewsTO.class);
	}

	@Override
	public NewsTO findById(Long id) {
		News news = newsDAO.find(id);
		return ObjectMapper.getInstance().getDozerConverter().convert(news, NewsTO.class);
	}
}
