package pl.wroc.uni.unf.domain.dao.bean;

import pl.wroc.uni.unf.domain.dao.EntityDAO;

import java.io.Serializable;

/**
 * @author Notechus.
 */
public abstract class BaseEntityDAO<T extends Serializable, ID extends Number> implements EntityDAO<T, ID> {

	@Override
	public T create(T entity) {
		return null;
	}

	@Override
	public T update(T entity) {
		return null;
	}

	@Override
	public void delete(ID id) {

	}

	@Override
	public T find(ID id) {
		return null;
	}

	@Override
	public T findAll() {
		return null;
	}
}
