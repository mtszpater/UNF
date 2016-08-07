package pl.wroc.uni.unf.domain.dao.bean;

import pl.wroc.uni.unf.domain.dao.UserDAO;
import pl.wroc.uni.unf.domain.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Notechus.
 */
public class UserDAOBean implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User create(User entity) {
		entityManager.persist(entity);

		return entity;
	}

	@Override
	public User update(User entity) {
		entityManager.merge(entity);

		return entity;
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(User.class, id));
	}

	@Override
	public User find(Long id) {
		return (User) entityManager.find(User.class, id);
	}

	@Override
	public User findAll() {
		return null;
	}

	@Override
	public List<User> findUserByUsername(String username) {
		return null;
	}

	@Override
	public List<User> findUserByEmail(String email) {
		return null;
	}
}
