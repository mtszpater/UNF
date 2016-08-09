package pl.wroc.uni.unf.domain.to;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

	public NewsTO(String title, String description, Date date, Integer duration, String place) {
		this.title = title;
		this.description = description;
		this.date = date;
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

		return new EqualsBuilder().append(title, castOther.title)
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
}
