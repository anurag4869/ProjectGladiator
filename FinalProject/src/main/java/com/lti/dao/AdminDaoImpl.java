package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.TableAdmin;
import com.lti.entity.TableStudent;

@Repository
public class AdminDaoImpl {
	@PersistenceContext
	protected EntityManager entityManager;

	public TableAdmin validateAdminCredentials(String email, String pwd){
		TableAdmin admin=null;
		String query="select a from TableAdmin a where adminEmail=:aEmail and adminPwd=:aPassword ";
	    Query q = entityManager.createQuery(query);
		q.setParameter("aEmail", email);
		q.setParameter("aPassword", pwd);
		try {
		admin=(TableAdmin)q.getSingleResult();
		return admin;
		}
		catch(NoResultException e) {
			
		}
		return admin;
	}
}
