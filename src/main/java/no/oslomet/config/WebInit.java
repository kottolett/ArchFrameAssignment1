package no.oslomet.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebInit implements WebApplicationInitializer {
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 1. register context
        context.register(WebConfig.class);
        // 2 set Servlet
        context.setServletContext(container);
        // 3 create servlet object

        ServletRegistration.Dynamic servlet =
                container.addServlet("dispatcher", new DispatcherServlet(context));

        // 4 Load
        servlet.setLoadOnStartup(1);
        // Add mapping
        servlet.addMapping("/");


    }
}

