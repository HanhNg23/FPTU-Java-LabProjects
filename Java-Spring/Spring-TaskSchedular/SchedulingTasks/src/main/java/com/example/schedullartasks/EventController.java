package com.example.schedullartasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Event")
public class EventController {
@Autowired
ScheduleTasks service;

@GetMapping
public void removeJob() {
	service.event2();
}

	
}
