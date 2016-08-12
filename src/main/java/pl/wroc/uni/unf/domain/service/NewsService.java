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

	public void postNews(String title, String description, Date date, String username);

	public NewsTO updateNews(News news);

	public void deleteNews(Long id);

	public List<NewsTO> findAll();

	public List<NewsTO> findByUser(String username);

	public List<NewsTO> findByDate(Date date);

	public NewsTO findById(Long id);

	public NewsTO updateNews(Long id, String title, String description);
}
