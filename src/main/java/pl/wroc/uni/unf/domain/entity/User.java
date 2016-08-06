package pl.wroc.uni.unf.domain.entity;

import javax.persistence.*;

/**
 * @author Notechus.
 */
@Entity
@Table(name = "USER")
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;

	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
