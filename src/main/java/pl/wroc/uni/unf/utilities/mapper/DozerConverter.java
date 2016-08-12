package pl.wroc.uni.unf.utilities.mapper;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Notechus.
 */
public class DozerConverter {

	private DozerBeanMapper dozerBeanMapper;

	public DozerConverter() {
		dozerBeanMapper = new DozerBeanMapper(prepareMappingList());
	}

	public <T> T convert(Object source, Class<T> destinationClass) {
		return dozerBeanMapper.map(source, destinationClass);
	}

	public <T> List<T> convertList(List<?> list, Class<T> destinationClass) {
		List<T> resultList = new ArrayList<>(list.size());
		for (Object i : list) {
			resultList.add(convert(i, destinationClass));
		}
		return resultList;
	}

	private List<String> prepareMappingList() {
		List<String> list = new ArrayList<>();
		list.add("mappings/domain_mappings.xml");

		return list;
	}
}
