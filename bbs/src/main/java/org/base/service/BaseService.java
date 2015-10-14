package org.base.service;

import java.io.Serializable;
import java.util.List;

import org.base.dao.BaseDao;
import org.base.entity.Page;

public interface BaseService<T> {
    
    public abstract void setBaseDao(BaseDao<T> baseDao);
    
    public abstract void add(T t);
    
    public abstract void update(T t);
    
    public abstract void delete(Serializable id);
    
    public abstract T get(Serializable id);
    
    public abstract T load(Serializable id);
    
    public abstract List<T> listAll();
    
    public abstract Page<T> findPage();
    
    public abstract Page<T> findByKeyWordLike(String attribute, String keyword);
    
}