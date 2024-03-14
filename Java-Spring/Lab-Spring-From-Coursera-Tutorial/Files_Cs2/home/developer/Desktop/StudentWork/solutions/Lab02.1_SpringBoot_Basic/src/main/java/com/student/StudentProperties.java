package com.student;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "student")
//The prefix of “student” will only find a greeting value nested 
//under that parent and inject it into the StudentProperties class

public class StudentProperties {

	private String greeting;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
}
