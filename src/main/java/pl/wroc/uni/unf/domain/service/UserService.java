package pl.wroc.uni.unf.domain.service;

import pl.wroc.uni.unf.domain.to.UserTO;

import java.util.List;

/**
 * @author Notechus.
 */
public interface UserService {

	public UserTO addUser(String username, String password, String email);

	public UserTO updateUser(String username, String email);

	public boolean changePassword(String username, String password);

	public void deleteUser(String username);

	public List<UserTO> findAll();

	public UserTO find(String username);

	public UserTO findByEmail(String email);

}
