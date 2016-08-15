package pl.wroc.uni.unf.domain.entity;

/**
 * @author Notechus.
 */
public enum AuthorityType {
	ADMIN("ROLE_ADMIN"),
	MODERATOR("ROLE_MODERATOR"),
	USER("ROLE_USER");

	private String name;

	AuthorityType(String name) {
		this.name = name;
	}

}
