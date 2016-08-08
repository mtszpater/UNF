package pl.wroc.uni.unf.domain.to;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * @author Notechus.
 */
public class NewsTO {

	private String title;
	private String description;
	private Date date;
	private Integer duration;
	private String place;

	public NewsTO() {

	}

	public NewsTO(String title, String description, Date date, Integer duration, String place) {
		this.title = title;
		this.description = description;
		this.date = date;
		this.duration = duration;
		this.place = place;
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) return true;

		if (!(other instanceof NewsTO)) return false;

		NewsTO castOther = (NewsTO) other;

		return new EqualsBuilder().append(title, castOther.title)
				.append(description, castOther.description)
				.append(date, castOther.date)
				.append(duration, castOther.duration)
				.append(place, castOther.place)
				.build();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(date)
				.append(place)
				.hashCode();
	}
}
