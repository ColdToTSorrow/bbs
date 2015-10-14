package org.bbs.dao.impl;

import org.base.dao.BaseDaoImpl;
import org.base.entity.Page;
import org.bbs.dao.UserDao;
import org.bbs.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findByUsername(String username) {
		String hql = "FROM User u where u.username = ?";
		User u = (User) this.queryObject(hql, new Object[] { username }, null);
		return u;
	}

	@Override
	public User findByEmail(String email) {
		String hql = "FROM User u where u.email = ?";
		User u = (User) this.queryObject(hql, new Object[] { email }, null);
		return u;
	}

	@Override
	public Page<User> findByUsernameLike(String keyword) {
		String hql = "from User u where u.username like '%" + keyword + "%'";
		return this.findPage(hql);
	}

}
