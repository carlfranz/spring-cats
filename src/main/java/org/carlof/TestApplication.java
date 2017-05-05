package org.carlof;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TestApplication {
	static Log log = LogFactory.getLog(TestApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		log.info("Cats application started!");
	}
	
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/console/*");
	    registration.addInitParameter("webAllowOthers", "true");
	    return registration;
	}
}
