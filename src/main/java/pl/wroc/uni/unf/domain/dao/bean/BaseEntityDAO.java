package pl.wroc.uni.unf.domain.dao.bean;

import pl.wroc.uni.unf.domain.dao.EntityDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Notechus.
 */
public abstract class BaseEntityDAO<T extends Serializable, ID extends Serializable> implements EntityDAO<T, ID> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> type;

	public BaseEntityDAO() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T create(T entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		this.entityManager.merge(entity);
		return entity;
	}

	@Override
	public void delete(ID id) {
		this.entityManager.remove(this.entityManager.getReference(type, id));
	}

	@Override
	public T find(ID id) {
		return (T) this.entityManager.find(type, id);
	}

	@Override
	public List<T> findAll() {
		return entityManager.createQuery("Select t from " + type.getSimpleName() + " t").getResultList();
	}
}
