package pl.wroc.uni.unf.domain.dao.bean;

import org.springframework.stereotype.Repository;
import pl.wroc.uni.unf.domain.dao.UserDAO;
import pl.wroc.uni.unf.domain.entity.User;

import javax.persistence.Query;
import java.util.List;

/**
 * @author Notechus.
 */
@Repository("userDAO")
public class UserDAOBean extends BaseEntityDAO<User, String> implements UserDAO {

	@Override
	public User findUserByEmail(String email) {
		Query query = entityManager.createNamedQuery("UserDAO_findByEmail");
		query.setParameter("email", email);

		return (User) query.getSingleResult();
	}
}
