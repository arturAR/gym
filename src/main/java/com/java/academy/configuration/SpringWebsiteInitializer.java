package com.java.academy.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebsiteInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(SpringMvcConfiguration.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
		
		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", dispatcherServlet);
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("/");
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		servletContext.addFilter("characterEncodingFilter", characterEncodingFilter).addMappingForUrlPatterns(null, true, "/*");

		DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
		servletContext.addFilter("springSecurityFilterChain", delegatingFilterProxy).addMappingForUrlPatterns(null, true, "/secure/*");
	}

}
