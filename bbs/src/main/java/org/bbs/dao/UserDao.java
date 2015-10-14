package org.bbs.dao;

import org.base.dao.BaseDao;
import org.base.entity.Page;
import org.bbs.entity.User;

public interface UserDao extends BaseDao<User> {
    
    public User findByUsername(String Username);
    
    public User findByEmail(String email);
    
    public Page<User> findByUsernameLike(String keyword);
    
}