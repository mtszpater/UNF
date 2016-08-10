package pl.wroc.uni.unf.domain.dao.bean;

import org.springframework.stereotype.Repository;
import pl.wroc.uni.unf.domain.dao.NewsDAO;
import pl.wroc.uni.unf.domain.entity.News;
import pl.wroc.uni.unf.domain.entity.User;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * @author Notechus.
 */
@Repository("newsDAO")
public class NewsDAOBean extends BaseEntityDAO<News, Long> implements NewsDAO {
	@Override
	public List<News> findByDate(Date date) {
		Query query = entityManager.createNamedQuery("NewsDAO_findByDate");
		query.setParameter("date", date);

		return query.getResultList();
	}

	@Override
	public List<News> findByUser(String username) {
		Query query = entityManager.createNamedQuery("NewsDAO_findByUser");
		query.setParameter("username", username);

		return query.getResultList();
	}
}
