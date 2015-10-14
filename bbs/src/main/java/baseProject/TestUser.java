package baseProject;

import org.base.entity.Page;
import org.bbs.dao.UserDao;
import org.bbs.entity.User;
import org.bbs.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestUser {
    
    @Autowired
    UserService ser;
    
    @Autowired
    UserDao dao;
    
    @Test
    public void testFindByUsername() {
        User u = ser.findByUsername("狠人大帝");
        System.out.println(u);
        User u2 = ser.findByUsername("狠人大帝");
        System.out.println(u2);
    }
    
    @Test
    public void testSave() {
        int i = 10;
        while ((i--) > 0) {
            User u = new User();
            u.setUsername("风清扬3");
            u.setPassword("123456");
            ser.createUser(u);
            System.out.println(u);
        }
    }
    
    @Test
    public void testFindByUsernameLike() {
        Page<User> p = dao.findByUsernameLike("狠人");
        
    }
    
    @Test
    public void testDelete() {
        ser.delete(Long.parseLong("2"));
        
    }
    
}