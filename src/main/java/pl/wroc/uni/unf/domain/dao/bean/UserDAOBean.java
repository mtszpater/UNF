package pl.wroc.uni.unf.domain.dao.bean;

import pl.wroc.uni.unf.domain.dao.UserDAO;
import pl.wroc.uni.unf.domain.entity.User;

import javax.persistence.Query;
import java.util.List;

/**
 * @author Notechus.
 */
public class UserDAOBean extends BaseEntityDAO<User, Long> implements UserDAO {

	@Override
	public List<User> findUserByUsername(String username) {
		//Query<User> query = entityManager.createNamedQuery("UserDAO_findAll");
		Query query = entityManager.createNamedQuery("UserDAO_findByUsername");
		query.setParameter("username", username);

		return query.getResultList();
	}

	@Override
	public List<User> findUserByEmail(String email) {
		Query query = entityManager.createNamedQuery("UserDAO_findByEmail");
		query.setParameter("email", email);

		return query.getResultList();
	}
}
