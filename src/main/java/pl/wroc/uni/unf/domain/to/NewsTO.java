package pl.wroc.uni.unf.domain.to;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author Notechus.
 */
public class NewsTO {

	private Long id;
	private String username;
	private String title;
	private String description;
	private Date date;

	public NewsTO() {

	}

	public NewsTO(Long id, String username, String title, String description, Date date) {
		this.id = id;
		this.username = username;
		this.title = title;
		this.description = description;
		this.date = date;
	}

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

	@Override
	public boolean equals(Object other) {
		if (this == other) return true;

		if (!(other instanceof NewsTO)) return false;

		NewsTO castOther = (NewsTO) other;

		return new EqualsBuilder().append(id, castOther.id)
				.append(username, castOther.username)
				.append(title, castOther.title)
				.append(description, castOther.description)
				.append(date, castOther.date)
				.build();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(date)
				.append(username)
				.hashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("username", username)
				.append("title", title)
				.append("description", description)
				.append("date", date)
				.toString();
	}
}
