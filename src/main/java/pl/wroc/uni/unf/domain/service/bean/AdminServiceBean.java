package pl.wroc.uni.unf.domain.service.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wroc.uni.unf.domain.dao.UserDAO;
import pl.wroc.uni.unf.domain.service.AdminService;
import pl.wroc.uni.unf.domain.to.UserTO;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Notechus.
 */
@Transactional
@Service("adminService")
public class AdminServiceBean implements AdminService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void addPrivilegeForUser(String username) {

	}

	@Override
	public void revokePrivilegeFromUser(String username) {

	}

	@Override
	public List<UserTO> findUsers() {
		return null;
	}

	@Override
	public List<UserTO> findUsersByRole(String role) {
		return null;
	}
}
