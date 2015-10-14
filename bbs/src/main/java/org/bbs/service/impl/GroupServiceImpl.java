package org.bbs.service.impl;

import org.base.service.BaseServiceImpl;
import org.bbs.dao.GroupDao;
import org.bbs.entity.Group;
import org.bbs.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceImpl extends BaseServiceImpl<Group> implements GroupService {
    
	 @Autowired
	 private GroupDao groupDao;
    
}
