package org.bbs.service;

import java.util.Set;

import org.base.entity.Page;
import org.base.service.BaseService;
import org.bbs.entity.User;

public interface UserService extends BaseService<User> {
    
    public abstract void createUser(User user);
    
    public abstract long resetPassword(String username, String password);
    
    /**
     * 根据用户名查找用户
     * 
     * @param username
     * @return
     */
    public abstract User findByUsername(String username);
    
    /**
     * 根据用户名查找其角色
     * 
     * @param username
     * @return
     */
    public abstract Set<String> findRoles(String username);
    
    /**
     * 根据用户名查找其权限
     * 
     * @param username
     * @return
     */
    public abstract Set<String> findPermissions(String username);
    
    public abstract User findByEmail(String email);
    
    public abstract Page<User> findByUsernameLike(String keyword);
    
}