package org.bbs.controller;

import java.io.UnsupportedEncodingException;

import org.base.entity.Page;
import org.base.entity.SystemContext;
import org.bbs.entity.User;
import org.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false) String keyword) throws UnsupportedEncodingException {
        
        Page<User> page = null;
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        if (null != keyword && !("").equals(keyword)) {
            keyword = new String(keyword.getBytes("ISO-8859-1"), "utf-8");
            // page = userService.findByUsernameLike(keyword);
            page = userService.findByKeyWordLike("username", keyword);
            model.addAttribute("keyword", keyword);
        } else page = userService.findPage();
        SystemContext.removeOrder();
        SystemContext.removeSort();
        model.addAttribute("page", page);
        return "admin/user/list";
    }
    

}
