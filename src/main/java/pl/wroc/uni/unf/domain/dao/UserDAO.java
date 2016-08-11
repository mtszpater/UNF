package pl.wroc.uni.unf.domain.dao;

import pl.wroc.uni.unf.domain.entity.User;

/**
 * @author Notechus.
 */
public interface UserDAO extends EntityDAO<User, String> {

	public User findUserByEmail(String email);

}
