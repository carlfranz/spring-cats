package org.carlof;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestApplication {
	static Log log = LogFactory.getLog(TestApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		log.info("Cats application started!");
	}
}
