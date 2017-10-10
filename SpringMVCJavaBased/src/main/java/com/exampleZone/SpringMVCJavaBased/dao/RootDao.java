package com.exampleZone.SpringMVCJavaBased.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author chinmay
 *
 * @param <K>    
 * @param <T>
 */
public abstract class RootDao <K,T extends Serializable> {

	private final Class<T> persistentClass;
	
	/**
	 * Check how does spring inject sessoinFactory without defining a bean to initaialize it in JPAConfiguration class
	 */
/*	@Autowired
	private SessionFactory sessionFactor;*/
	
	@PersistenceContext
	EntityManager entityManager;
	
	/*
	 * reflection is been used here , go through this part 
	 * and also find other way to fetch Class type of the current extending class at runtime (for method getById() )
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public RootDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	/**
	 * @return Session from Hibernate
	 */
	protected Session getSession()
	{
		return entityManager.unwrap(Session.class);
	}
	
	protected EntityManager setEntityManager()
	{
		return entityManager;
	}
	
	protected T getById( K id )
	{
		return (T) entityManager.find(persistentClass, id);
	}
	
	protected  void persist(T entity)
	{
		entityManager.persist(entity);
	}
	
	protected  void update(T entity)
	{
		entityManager.merge(entity);
	}
	
	protected void delete(T entity)
	{
		entityManager.remove(entity);
	}
	
	protected Criteria getEntityCriteria()
	{
		return getSession().createCriteria(persistentClass);
	}
}
