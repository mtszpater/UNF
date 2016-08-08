package pl.wroc.uni.unf.utilities.mapper;

/**
 * @author Notechus.
 */
public class ObjectMapper {
	private static ObjectMapper instance = null;
	private DozerConverter dozerConverter;

	private ObjectMapper() {
		dozerConverter = new DozerConverter();
	}

	public static ObjectMapper getInstance() {
		if (instance == null) {
			instance = new ObjectMapper();
		}
		return instance;
	}

	public DozerConverter getDozerConverter() {
		return dozerConverter;
	}
}
