package pl.wroc.uni.unf.domain.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Notechus.
 */
public interface EntityDAO<T extends Serializable, ID extends Serializable> {
	public T create(T entity);

	public T update(T entity);

	public void delete(ID id);

	public T find(ID id);

	public List<T> findAll();
}
