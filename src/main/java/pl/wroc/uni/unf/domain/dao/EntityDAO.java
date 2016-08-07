package pl.wroc.uni.unf.domain.dao;

import java.io.Serializable;

/**
 * @author Notechus.
 */
public interface EntityDAO<T extends Serializable, ID extends Number> {
	public T create(T entity);

	public T update(T entity);

	public void delete(ID id);

	public T find(ID id);

	public T findAll();
}
