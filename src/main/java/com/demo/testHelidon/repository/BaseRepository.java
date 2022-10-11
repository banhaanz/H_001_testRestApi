package com.demo.testHelidon.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public abstract class BaseRepository<T,PK> {
	@PersistenceContext
	protected EntityManager em;
	protected Class<T> entityClass  ;
	protected Class<PK> pkClass  ;

	public BaseRepository(){
		loadActualType();
	}
	private void loadActualType(){
//		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
//		if(pt != null){
//			if(pt.getActualTypeArguments() != null){
//				if(pt.getActualTypeArguments().length > 0){
//					entityClass = (Class<T>) pt.getActualTypeArguments()[0];
//				}
//				if(pt.getActualTypeArguments().length > 1){
//					pkClass = (Class<PK>) pt.getActualTypeArguments()[1];
//				}
//			}
//		}
	}

	@Transactional(value= Transactional.TxType.REQUIRES_NEW)
	public T getByPk(PK pk){
		return em.find(entityClass, pk);
	}

	public List<T> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> rootEntry = cq.from(entityClass);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = em.createQuery(all);
		return allQuery.getResultList();
		}

	@Transactional(value= Transactional.TxType.MANDATORY)
	public T create(T t){
		em.persist(t);
		em.flush();
		return t;
	}

	@Transactional(value= Transactional.TxType.MANDATORY)
	public T update(T t){
		em.merge(t);
		em.flush();
		return t;
	}
}
