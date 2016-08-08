package pl.wroc.uni.unf.webservice.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan("pl.wroc.uni.unf")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


