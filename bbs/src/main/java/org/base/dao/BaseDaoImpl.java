package org.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.base.entity.Page;
import org.base.entity.SystemContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("baseDao")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {
    
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    /**
     * 创建一个Class的对象来获取泛型的class
     */
    private Class<?> clz;
    
    public Class<?> getClz() {
        if (clz == null) {
            // 获取泛型的Class对象
            clz = ((Class<?>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
            
        }
        return clz;
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#save(T)
     */
    @Override
    public Serializable save(T o) {
        return this.getCurrentSession().save(o);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#delete(T)
     */
    @Override
    public void delete(T o) {
        this.getCurrentSession().delete(o);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#update(T)
     */
    @Override
    public void update(T o) {
        this.getCurrentSession().update(o);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#saveOrUpdate(T)
     */
    @Override
    public void saveOrUpdate(T o) {
        this.getCurrentSession().saveOrUpdate(o);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#find(java.lang.String)
     */
    @Override
    public List<T> list(String hql) {
        return this.getCurrentSession().createQuery(hql).list();
    }
    
    public List<T> list(String hql, Object arg) {
        return this.list(hql, new Object[] { arg });
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#find(java.lang.String, java.lang.Object[])
     */
    @Override
    public List<T> list(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.list();
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#find(java.lang.String, java.util.List)
     */
    @Override
    public List<T> list(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.list();
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#find(java.lang.String, java.lang.Object[],
     * java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<T> list(String hql, Object[] param, Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#find(java.lang.String, java.util.List,
     * java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<T> list(String hql, List<Object> param, Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#get(java.lang.Class, java.io.Serializable)
     */
    @Override
    public T load(Serializable id) {
        return (T) this.getCurrentSession().load(this.getClz(), id);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#get(java.lang.Class, java.io.Serializable)
     */
    @Override
    public T get(Serializable id) {
        return (T) this.getCurrentSession().get(this.getClz(), id);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#get(java.lang.String, java.lang.Object[])
     */
    @Override
    public T get(String hql, Object[] param) {
        List<T> l = this.list(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#get(java.lang.String, java.util.List)
     */
    @Override
    public T get(String hql, List<Object> param) {
        List<T> l = this.list(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#count(java.lang.String)
     */
    @Override
    public Long count(String hql) {
        return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#count(java.lang.String, java.lang.Object[])
     */
    @Override
    public Long count(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return (Long) q.uniqueResult();
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#count(java.lang.String, java.util.List)
     */
    @Override
    public Long count(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return (Long) q.uniqueResult();
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#executeHql(java.lang.String)
     */
    @Override
    public Integer executeHql(String hql) {
        return this.getCurrentSession().createQuery(hql).executeUpdate();
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#executeHql(java.lang.String,
     * java.lang.Object[])
     */
    @Override
    public Integer executeHql(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.executeUpdate();
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.base.dao.BaseDao#executeHql(java.lang.String,
     * java.util.List)
     */
    @Override
    public Integer executeHql(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.executeUpdate();
    }
    
    @Override
    public List<T> listAll() {
        return this.getCurrentSession().createQuery(//
                "FROM " + getClz().getSimpleName())//
                .list();
    }
    
    @Override
    public Page<T> findPage() {
        Integer pageSize = SystemContext.getPageSize();
        Integer pageNum = SystemContext.getPageNum();
        if (pageNum == null || pageNum < 0)
            pageNum = 0;
        if (pageSize == null || pageSize < 0)
            pageSize = 15;
        String hql = "FROM " + getClz().getSimpleName();//
        hql = initSort(hql);
        List list = sessionFactory.getCurrentSession().createQuery(hql)//
                .setFirstResult((pageNum - 1) * pageSize)//
                .setMaxResults(pageSize)//
                .list();
        Long count = (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM " + getClz().getSimpleName())//
                .uniqueResult();
        return new Page(pageNum, count.intValue(), pageSize, list);
    }
    
    public Page<T> findPage(String hql, Object[] args) {
        return this.findPage(hql, args, null);
    }
    
    /*
     * (non-Javadoc)
     * @see org.konghao.baisc.dao.IBaseDao#find(java.lang.String,
     * java.lang.Object)
     */
    public Page<T> findPage(String hql, Object arg) {
        return this.findPage(hql, new Object[] { arg });
    }
    
    /*
     * (non-Javadoc)
     * @see org.konghao.baisc.dao.IBaseDao#find(java.lang.String)
     */
    public Page<T> findPage(String hql) {
        return this.findPage(hql, null);
    }
    
    public Page<T> findPage(String hql, Object[] args, Map<String, Object> alias) {
        hql = initSort(hql);
        String cq = getCountHql(hql, true);
        Query cquery = getSession().createQuery(cq);
        Query query = getSession().createQuery(hql);
        // 设置别名参数
        setAliasParameter(query, alias);
        setAliasParameter(cquery, alias);
        // 设置参数
        setParameter(query, args);
        setParameter(cquery, args);
        Number total = (Number) cquery.uniqueResult();
        Integer pageSize = SystemContext.getPageSize();
        Integer pageNum = SystemContext.getPageNum();
        if (pageNum == null || pageNum < 0)
            pageNum = 0;
        if (pageSize == null || pageSize < 0)
            pageSize = 15;
        query.setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageSize);
        List<T> list = query.list();
        return new Page(pageNum, total.intValue(), pageSize, list);
    }
    
    private String initSort(String hql) {
        String order = SystemContext.getOrder();
        String sort = SystemContext.getSort();
        if (sort != null && !"".equals(sort.trim())) {
            hql += " order by " + sort;
            if (!"desc".equals(order))
                hql += " asc";
            else hql += " desc";
        }
        return hql;
    }
    
    @SuppressWarnings("rawtypes")
    private void setAliasParameter(Query query, Map<String, Object> alias) {
        if (alias != null) {
            Set<String> keys = alias.keySet();
            for (String key : keys) {
                Object val = alias.get(key);
                if (val instanceof Collection) {
                    // 查询条件是列表
                    query.setParameterList(key, (Collection) val);
                } else {
                    query.setParameter(key, val);
                }
            }
        }
    }
    
    private void setParameter(Query query, Object[] args) {
        if (args != null && args.length > 0) {
            int index = 0;
            for (Object arg : args) {
                query.setParameter(index++, arg);
            }
        }
    }
    
    private String getCountHql(String hql, boolean isHql) {
        String e = hql.substring(hql.indexOf("from"));
        String c = "select count(*) " + e;
        if (isHql)
            c = c.replaceAll("fetch", "");
        return c;
    }
    
    public Object queryObject(String hql, Object[] args, Map<String, Object> alias) {
        Query query = getSession().createQuery(hql);
        setAliasParameter(query, alias);
        setParameter(query, args);
        return query.uniqueResult();
    }
    
    public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
        return this.queryObject(hql, null, alias);
    }
    
    public Page<T> findByKeyWordLike(String attribute, String keyword) {
        String hql = "from " + getClz().getSimpleName() + " where " + attribute + " like '%" + keyword + "%'";
        return this.findPage(hql);
    }
    
}
