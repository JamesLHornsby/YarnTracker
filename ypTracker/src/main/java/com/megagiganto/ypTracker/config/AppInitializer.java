package com.megagiganto.ypTracker.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class < ? > [] getRootConfigClasses() {
        return new Class[] {AppContext.class};
    }

    @Override
    protected Class < ? > [] getServletConfigClasses() {
        return new Class[] {MvcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    //not from site
//    @Override
//	public void onStartup(ServletContext servletContext) 
//	  throws ServletException {
//	  super.onStartup(servletContext);
//	  ServletRegistration.Dynamic servlet = servletContext.
//	    addServlet("h2-console", new WebServlet());
//	  servlet.setLoadOnStartup(2);
//	  servlet.addMapping("/console/*");
//	}
}