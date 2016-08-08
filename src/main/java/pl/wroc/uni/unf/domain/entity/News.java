package pl.wroc.uni.unf.domain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Notechus.
 */
@Entity
@Table(name = "NEWS")
public class News implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "NEWS_ID", nullable = false, unique = true)
	private Long id;

	@ManyToOne(targetEntity = User.class)
	private User user;

	@Column(name = "TITLE", nullable = false)
	private String title;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "DATE", nullable = false)
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
