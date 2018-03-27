package org.o7planning.sbangularjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootAngularJsApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularJsApplication.class, args);
	}
}