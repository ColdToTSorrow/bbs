package org.base.dao;

import java.io.Serializable;
import java.util.List;

import org.base.entity.Page;

public interface BaseDao<T> {
    
    public abstract Serializable save(T o);
    
    public abstract void delete(T o);
    
    public abstract void update(T o);
    
    public abstract void saveOrUpdate(T o);
    
    public abstract List<T> list(String hql);
    
    public abstract List<T> list(String hql, Object[] param);
    
    public abstract List<T> list(String hql, List<Object> param);
    
    public abstract List<T> list(String hql, Object[] param, Integer page, Integer rows);
    
    public abstract List<T> list(String hql, List<Object> param, Integer page, Integer rows);
    
    public abstract T get(Serializable id);
    
    public abstract T get(String hql, Object[] param);
    
    public abstract T get(String hql, List<Object> param);
    
    public abstract Long count(String hql);
    
    public abstract Long count(String hql, Object[] param);
    
    public abstract Long count(String hql, List<Object> param);
    
    public abstract Integer executeHql(String hql);
    
    public abstract Integer executeHql(String hql, Object[] param);
    
    public abstract Integer executeHql(String hql, List<Object> param);
    
    public abstract T load(Serializable id);
    
    public abstract List<T> listAll();
    
    public abstract Page<T> findPage();
    
    public abstract Page<T> findByKeyWordLike(String attribute, String keyword);
    
}