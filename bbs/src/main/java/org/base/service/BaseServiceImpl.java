package org.base.service;

import java.io.Serializable;
import java.util.List;

import org.base.dao.BaseDao;
import org.base.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
    
    /** baseDao */
    private BaseDao<T> baseDao;
    
    /*
     * (non-Javadoc)
     * @see
     * org.hxj.base.service.impl.BaseService#setBaseDao(org.hxj.base.dao.BaseDao
     * )
     */
    @Override
    @Autowired
    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.service.impl.BaseService#add(T)
     */
    @Override
    @Transactional
    public void add(T t) {
        baseDao.save(t);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.service.impl.BaseService#update(T)
     */
    @Override
    public void update(T t) {
        baseDao.update(t);
        
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.service.impl.BaseService#delete(java.io.Serializable)
     */
    @Override
    public void delete(Serializable id) {
        baseDao.delete(baseDao.get(id));
        
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.service.impl.BaseService#get(java.io.Serializable)
     */
    @Override
    public T get(Serializable id) {
        return baseDao.get(id);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.service.impl.BaseService#listAll()
     */
    @Override
    public List<T> listAll() {
        return baseDao.listAll();
    }
    
    @Override
    public Page<T> findPage() {
        return baseDao.findPage();
    }
    
    @Override
    public T load(Serializable id) {
        return baseDao.load(id);
    }
    
    @Override
    public Page<T> findByKeyWordLike(String attribute, String keyword) {
        return baseDao.findByKeyWordLike(attribute, keyword);
    }
    
}
