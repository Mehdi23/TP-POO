package org.mehdi.project.dao.implementation;

import java.util.List;

import org.mehdi.project.dao.interfaces.ObjectifyGenericDaoInterface;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

public class ObjectifyGenericDao<T> implements ObjectifyGenericDaoInterface<T> {

	@Override
	public Key<T> put(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Key<T>> putAll(Iterable<T> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKey(Key<T> entityKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKeys(Iterable<Key<T>> keys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(Key<T> key) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Key<T>> listKeysByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getByExample(T exampleObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listByExample(T exampleObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> asListe(Iterable<T> iterable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Key<T>> asKeyList(Iterable<Key<T>> iterableKeys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query<T> buildQueryByExample(T exampleObj) {
		// TODO Auto-generated method stub
		return null;
	}

}
