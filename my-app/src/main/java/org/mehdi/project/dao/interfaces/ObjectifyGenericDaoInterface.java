package org.mehdi.project.dao.interfaces;

import java.util.List;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.cmd.Query;

public interface ObjectifyGenericDaoInterface<T> {
	
    public Key<T> put(T entity);
 
    public List<Key<T>> putAll(Iterable<T> entities);
 
    public void delete(T entity);
 
    public void deleteKey(Key<T> entityKey);
 
    public void deleteAll(Iterable<T> entities);
 
    public void deleteKeys(Iterable<Key<T>> keys);
    
    public T get(Long id) throws EntityNotFoundException;
 
    public T get(Key<T> key) throws EntityNotFoundException;
 
    /**
     * Convenience method to get all objects matching a single property
     *
     * @param propName
     * @param propValue
     * @return T matching Object
     */
    public T getByProperty(String propName, Object propValue);
 
    public List<T> listByProperty(String propName, Object propValue);
 
    public List<Key<T>> listKeysByProperty(String propName, Object propValue);
 
    public T getByExample(T exampleObj);
 
    public List<T> listByExample(T exampleObj);

    public List<T> asListe(Iterable<T> iterable);
 
    public List<Key<T>> asKeyList(Iterable<Key<T>> iterableKeys);
 
    public Query<T> buildQueryByExample(T exampleObj);

}
