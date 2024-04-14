package com.example.schedullartasks;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class ThreadPoolTaskSchedulerConfig implements SchedulingConfigurer {
	TaskScheduler taskScheduler;
	ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
	@Bean
	public TaskScheduler getTaskScheduler() {
		this.threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setThreadGroupName("scheduler-thread");
		threadPoolTaskScheduler.initialize();
		this.taskScheduler = this.threadPoolTaskScheduler;
		return this.taskScheduler;
	}
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setTaskScheduler(taskScheduler);
	}
	

	
	

	
	
}
