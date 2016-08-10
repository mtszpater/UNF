package pl.wroc.uni.unf.domain.dao;

import org.springframework.stereotype.Repository;
import pl.wroc.uni.unf.domain.entity.User;

import java.util.List;

/**
 * @author Notechus.
 */
public interface UserDAO extends EntityDAO<User, Long> {

	public User findUserByUsername(String username);

	public User findUserByEmail(String email);

}
