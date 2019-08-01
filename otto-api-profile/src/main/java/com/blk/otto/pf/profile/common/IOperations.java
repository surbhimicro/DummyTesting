package com.blk.otto.pf.profile.common;

import java.util.List;
import java.util.Optional;

 /**
 * @param <T> : entity class
 * @param <ID> : unique id type of entity class
 */
public interface IOperations<T, ID> {

	public T save(T entity);

	public Optional<T> findById(ID id);

	public boolean existsById(ID id);

	public long count();

	public void deleteById(ID id);

	public void delete(T entity);

	public void deleteAll();

	public List<T> findAll();
    
}
