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
		dozerBeanMapper = new DozerBeanMapper();
	}

	public Object convert(Object ob, Class c) {
		return dozerBeanMapper.map(ob, c);
	}

	public Object convertList(List list, Class c) {
		List resList = new ArrayList();
		for (Object i : list) {
			resList.add(convert(i, c));
		}
		return resList;
	}
}
