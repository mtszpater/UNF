package pl.wroc.uni.unf.domain.dao;

import pl.wroc.uni.unf.domain.entity.News;

import java.util.Date;
import java.util.List;

/**
 * @author Notechus.
 */
public interface NewsDAO extends EntityDAO<News, Long> {
	public List<News> findByDate(Date date);

	public List<News> findByPlace(String place);

	public List<News> findByUser(String username);
}
