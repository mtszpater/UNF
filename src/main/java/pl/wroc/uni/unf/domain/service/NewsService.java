package pl.wroc.uni.unf.domain.service;

import pl.wroc.uni.unf.domain.entity.News;
import pl.wroc.uni.unf.domain.to.NewsTO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author Notechus.
 */
public interface NewsService {

	public void postNews(String title, String description, Date date, Integer duration, String place, Integer userId);

	public NewsTO updateNews(News news);

	public List<NewsTO> findAll();

	public List<NewsTO> findByUser(String username);

	public List<NewsTO> findByDate(Date date);
}
