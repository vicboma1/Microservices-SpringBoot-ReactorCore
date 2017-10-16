package com.vicboma.fwk.spring.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= "com.vicboma.fwk.spring.boot")
public class Demo1Application {

	public static void main(String[] args) {
		try {
			SpringApplication.run(Demo1Application.class, args);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("End process.");
		}
	}
}
