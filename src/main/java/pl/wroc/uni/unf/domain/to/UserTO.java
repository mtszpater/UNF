package pl.wroc.uni.unf.domain.to;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Notechus.
 */
public class UserTO {

	private String username;
	private String email;
	private boolean enabled;

	public UserTO() {
	}

	public UserTO(String username, String email, boolean enabled) {
		this.username = username;
		this.email = email;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		UserTO userTO = (UserTO) o;

		return new EqualsBuilder()
				.append(enabled, userTO.enabled)
				.append(username, userTO.username)
				.append(email, userTO.email)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(enabled)
				.toHashCode();
	}
}
