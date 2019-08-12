package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.TableStudent;

@Repository
public class GenericDaoImpl implements GenericDao{
	
	@PersistenceContext
	protected EntityManager entityManager;

	public Object save(Object obj) {
		// TODO Auto-generated method stub
		 return entityManager.merge(obj);
		 
	}
		public <E> E fetchById(Class<E> clazz, Object pk){
			return entityManager.find(clazz, pk);
		}
		
		public <E> List<E> fetchAll(Class<E> clazz) {
			String q="select obj from " + clazz.getName() + " as obj";
			return entityManager.createQuery(q).getResultList();
		}

		public void delete(Class clazz,Object pk) {
			Object object=entityManager.find(clazz,pk);
			
			entityManager.remove(object);
		}
	
	

	

}