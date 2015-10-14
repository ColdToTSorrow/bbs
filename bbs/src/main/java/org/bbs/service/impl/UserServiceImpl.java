package org.bbs.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

import org.base.entity.Page;
import org.base.service.BaseServiceImpl;
import org.bbs.dao.UserDao;
import org.bbs.entity.User;
import org.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    
    @Autowired
    private PasswordHelper passwordHelper;
    
    @Autowired
    private UserDao userDao;
    
    /*
     * (non-Javadoc)
     * @see
     * org.hxj.sys.service.impl.UserService#createUser(org.hxj.sys.entity.User)
     */
    @Override
    public void createUser(User user) {
        passwordHelper.encryptPassword(user);
        user.setCreateDate(new Date());
        this.add(user);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.sys.service.impl.UserService#resetPassword(java.lang.String,
     * java.lang.String)
     */
    @Override
    public long resetPassword(String username, String password) {
        User user = userDao.findByUsername(username);
        user.setPassword(password);
        passwordHelper.encryptPassword(user);
        return (long) userDao.save(user);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * org.hxj.sys.service.impl.UserService#findByUsername(java.lang.String)
     */
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.sys.service.impl.UserService#findRoles(java.lang.String)
     */
    @Override
    public Set<String> findRoles(String username) {
        User user = findByUsername(username);
        
        if (user == null) { return Collections.EMPTY_SET; }
  
        return null;
    }
    
    /*
     * (non-Javadoc)
     * @see
     * org.hxj.sys.service.impl.UserService#findPermissions(java.lang.String)
     */
    @Override
    public Set<String> findPermissions(String username) {
        
        User user = findByUsername(username);
        
        if (user == null) { return Collections.EMPTY_SET; }
       
        return null;
        
    }
    
    /*
     * (non-Javadoc)
     * @see org.hxj.sys.service.impl.UserService#findByEmail(java.lang.String)
     */
    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    
    @Override
    public Page<User> findByUsernameLike(String keyword) {
        return userDao.findByUsernameLike(keyword);
    }
    
}
