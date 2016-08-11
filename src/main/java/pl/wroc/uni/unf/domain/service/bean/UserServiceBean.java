package pl.wroc.uni.unf.domain.service.bean;

import pl.wroc.uni.unf.domain.service.UserService;
import pl.wroc.uni.unf.domain.to.UserTO;

import java.util.List;

/**
 * @author Notechus.
 */
public class UserServiceBean implements UserService {
	@Override
	public UserTO addUser(String username, String password, String email) {
		return null;
	}

	@Override
	public UserTO updateUser(String username, String email) {
		return null;
	}

	@Override
	public boolean changePassword(String username) {
		return false;
	}

	@Override
	public void deleteUser(String username) {

	}

	@Override
	public List<UserTO> findAll() {
		return null;
	}

	@Override
	public UserTO findByUsername(String username) {
		return null;
	}

	@Override
	public UserTO findByEmail(String email) {
		return null;
	}
}
