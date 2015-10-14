package org.bbs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.base.entity.SystemContext;

public class SystemContextFilter implements Filter {
    
    private Integer pageSize;
    
    @Override
    public void destroy() {
        
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        Integer pageNum = 1;
        try {
            pageNum = Integer.parseInt(req.getParameter("pageNum"));
            System.out.println(pageNum);
        } catch (NumberFormatException e) {
        }
        try {
            SystemContext.setOrder(req.getParameter("order"));
            SystemContext.setSort(req.getParameter("sort"));
            SystemContext.setPageNum(pageNum);
            SystemContext.setPageSize(pageSize);
            SystemContext.setRealPath(((HttpServletRequest) req).getSession().getServletContext().getRealPath("/"));
            chain.doFilter(req, resp);
        } finally {
            SystemContext.removeOrder();
            SystemContext.removeSort();
            SystemContext.removePageNum();
            SystemContext.removePageSize();
            SystemContext.removeRealPath();
        }
    }
    
    @Override
    public void init(FilterConfig cfg) throws ServletException {
        try {
            pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
        } catch (NumberFormatException e) {
            pageSize = 10;
        }
    }
    
}
