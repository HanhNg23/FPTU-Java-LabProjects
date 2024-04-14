package com.example.schedullartasks;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Synchronized;

@Service
public class ScheduleTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduleTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private AtomicInteger count ;

	@Autowired
	TaskScheduler taskScheduler;
	

	Map<String, ScheduledFuture<?>> scheduledEvents = new HashMap<>();

	@Bean
	public AtomicInteger getCount() {
		this.count = new AtomicInteger(0);
		return this.count;
	}

	@Scheduled(fixedRate = 6000)
	//@Async
    public void reportCurrntTime() {
        this.count.incrementAndGet();
        log.info("The count is now {} -- Result {} ", dateFormat.format(new Date()), this.count.get() );
    }

	// @Scheduled(cron = "*/10 * * * * *")
    public void reportScheduleAnnotation() {
        this.count.incrementAndGet();
        log.info("The count is now SCHEDULE {}", dateFormat.format(new Date()));
    }

   
	Runnable runEvent1 = new Runnable() {
		AtomicInteger count = new AtomicInteger(0);

		@Override
		public void run() {
				this.count.incrementAndGet();
				log.info("COUNT OF RUN EVENT 1 {} -- RESULT {} ", dateFormat.format(new Date()), this.count.get());
			
			
		}
	};

	Runnable runEvent2 = new Runnable() {
		@Override
		public void run() {
			log.info("COUNT OF RUN EVENT 2 {}", dateFormat.format(new Date()));
		}
	};
	
	//@Async
	@Bean
	public void event1() {
		ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(runEvent1, LocalDateTime.now().plusMinutes(1)
				.toInstant(LocalDateTime.now().atZone(ZoneOffset.systemDefault()).getOffset()));
		scheduledEvents.put("event1", scheduledFuture);
	}

	//@Async
	

	@Bean
	public void event2() {
		Trigger trigger = new Trigger() {
			@Override
			public Instant nextExecution(TriggerContext triggerContext) {
				String cronExp = "*/10 * * * * *";
				return new CronTrigger(cronExp).nextExecution(triggerContext);
			}
		};
		ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(runEvent2, trigger);
		scheduledEvents.put("event2", scheduledFuture);
	}
	
	@Bean
	public void cancelReport() {
		int delayInSeconds = 30;
		ScheduledFuture<?> event = scheduledEvents.get("event2");
		if (event != null) {
			taskScheduler.schedule(() -> {
				event.cancel(true);
				scheduledEvents.remove("event2");
				log.info("REMOVED EVENT 2");
			}, LocalDateTime.now().plusSeconds(30)
					.toInstant(LocalDateTime.now().atZone(ZoneOffset.systemDefault()).getOffset()));
		}
	}

}
