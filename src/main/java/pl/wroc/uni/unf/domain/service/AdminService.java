package pl.wroc.uni.unf.domain.service;

import pl.wroc.uni.unf.domain.to.UserTO;

import java.util.List;

/**
 * @author Notechus.
 */
public interface AdminService {

	public void addPrivilegeForUser(String username);

	public void revokePrivilegeFromUser(String username);

	public List<UserTO> findUsers();

	public List<UserTO> findUsersByRole(String role);
}
