package pl.wroc.uni.unf.domain.service.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wroc.uni.unf.domain.dao.UserDAO;
import pl.wroc.uni.unf.domain.entity.User;
import pl.wroc.uni.unf.domain.service.UserService;
import pl.wroc.uni.unf.domain.to.UserTO;
import pl.wroc.uni.unf.utilities.mapper.ObjectMapper;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Notechus.
 */
@Transactional
@Service("userService")
public class UserServiceBean implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserTO addUser(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setEnabled(true);
		userDAO.create(user);
		return ObjectMapper.getInstance().getDozerConverter().convert(user, UserTO.class);
	}

	@Override
	public UserTO updateUser(String username, String email) {
		User user = userDAO.find(username);
		if (!user.getUsername().equals(username)) {
			user.setUsername(username); // updating username is delicate thing! you should not do this!
		}
		return null;
	}

	@Override
	public boolean changePassword(String username, String password) {
		User user = userDAO.find(username);
		if (user == null) return false;
		user.setPassword(password);
		return true;
	}

	@Override
	public void deleteUser(String username) {
		userDAO.delete(username);
	}

	@Override
	public List<UserTO> findAll() {
		List<User> userList = userDAO.findAll();
		return ObjectMapper.getInstance().getDozerConverter().convertList(userList, UserTO.class);
	}

	@Override
	public UserTO find(String username) {
		User user = userDAO.find(username);
		return ObjectMapper.getInstance().getDozerConverter().convert(user, UserTO.class);
	}

	@Override
	public UserTO findByEmail(String email) {
		User user = userDAO.findUserByEmail(email);
		return ObjectMapper.getInstance().getDozerConverter().convert(user, UserTO.class);
	}
}
