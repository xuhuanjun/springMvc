package com.yi.context;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Servlet监听.<br>
 * <li>初始化上下文</li>
 * <li>销毁上下文</li>
 * <p>
 * Created by point on 2016/12/10.
 */
public class InitServletContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent event) {
        System.out.println("initialized");
        event.getServletContext().setAttribute("user", "admin");
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("destroyed");
    }


}
