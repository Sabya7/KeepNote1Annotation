package com.stackroute.keepnote.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletCxt) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(DispatcherConfig.class);
        ac.setServletContext(servletCxt);
        ac.refresh();


        // Create and register the DispatcherServlet
        DispatcherServlet temp = new DispatcherServlet(ac);
        ServletRegistration.Dynamic servlet = servletCxt.addServlet("dispatcher", temp);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");


    }
}