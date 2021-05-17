package co.move.in.test.BookMyShow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class BookMyShowApplication {
	private static final Logger logger = LogManager.getLogger(BookMyShowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
		logger.info("Application started");
	}

}
