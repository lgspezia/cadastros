package com.cadastro.boot.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cadastro.boot.model.Person;

public class AbstractDao<T> {

	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public Person update(T entity) {
		return (Person) entityManager.merge(entity);
	}

	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(entityClass, id));
	}

	public T findById(Long id) {
		return entityManager.find(entityClass, id);
	}
	
	public List<T> findAll(){
		return entityManager.createQuery("from "+ entityClass.getSimpleName(), entityClass).getResultList();
	}
	
}
