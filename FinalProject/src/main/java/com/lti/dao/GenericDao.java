package com.lti.dao;

import java.util.List;

public interface GenericDao {
	public void save(Object obj);
	public <E> E fetchById(Class<E> clazz, Object pk);
	public <E> List<E> fetchAll(Class<E> clazz);
}
