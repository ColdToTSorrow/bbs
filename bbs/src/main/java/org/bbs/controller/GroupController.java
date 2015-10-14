package org.bbs.controller;

import java.io.UnsupportedEncodingException;

import org.base.entity.Page;
import org.base.entity.SystemContext;
import org.bbs.entity.Group;
import org.bbs.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin/group")
public class GroupController {
    
    @Autowired
    GroupService groupService;
    
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false) String keyword) throws UnsupportedEncodingException {
        
        Page<Group> page = null;
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        if (null != keyword && !("").equals(keyword)) {
            keyword = new String(keyword.getBytes("ISO-8859-1"), "utf-8");
            // page = userService.findByUsernameLike(keyword);
            page = groupService.findByKeyWordLike("username", keyword);
            model.addAttribute("keyword", keyword);
        } else page = groupService.findPage();
        SystemContext.removeOrder();
        SystemContext.removeSort();
        model.addAttribute("page", page);
        return "admin/group/list";
    }
    
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String toUpdate(Long id, Model model) {
        Group group = groupService.get(id);     
        model.addAttribute("permissionStr", group.getPermission());    
    	model.addAttribute("id", id);
        return "admin/group/edit";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Long id, Model model,String[] permissions) {
    	model.addAttribute("id", id);
    	Group group = groupService.get(id); 
    	StringBuilder str = new StringBuilder();
    	for(int i=0;i<permissions.length;i++){
    	str.append(permissions[i]);
    	str.append(",");
    	}
    	if(str.length()>0){
    		String permission = str.substring(0,str.length()-1);
    		group.setPermission(permission);
    	}
    	groupService.update(group);
    	
        return  "redirect:/admin/group/list";
    }

}
