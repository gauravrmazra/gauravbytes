package com.gauravbytes.gkart.service;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.gauravbytes.gkart.service.exception.GenericServiceException;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 * @param <T>
 * @param <ID>
 */
public interface GenericService<T, ID extends Serializable> {
	public default Iterable<T> findAll() {
		return getRepository().findAll();
	}
	
	public default T get(ID id) {
		return getRepository().findOne(id);
	}
	
	public default T save(T entity) {
		return getRepository().save(entity);
	}
	
	public default void delete(ID id) {
		if (getRepository().exists(id)) {
			getRepository().delete(id);
		}
		else {
			throw new GenericServiceException("Rating>> 'id' doesn't exists: " + id);
		}
	}
	
	public default void update(T entity) {
		if (getRepository().exists(getId(entity))) {
			getRepository().save(entity);
		}
		else {
			throw new GenericServiceException("Can't update Rating because it doesn't exist in DB: " + entity);
		}
	}
	
	public ID getId(T entity);
	
	public CrudRepository<T, ID> getRepository();
}
