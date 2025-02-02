package com.student.aspect;

import javax.inject.Named;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.student.core.Student;

@Named
@Aspect
//Aspect is indicate unit of modularity for cross-cutting concerns
public class StudentAspect {
	//? Why need Logger obj
	private Logger LOG = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Pointcut("execution(* com.student.service.*.*(..))")
	public void log() {
		
	}
	
	@Before("log()")
	public void before(JoinPoint jopo) {
		String aspectannounce =  "Invoked Method Before->" + jopo.getSignature().getName();
		System.out.println(aspectannounce);
	}
	
	@After("log()")
	public void after(JoinPoint jopo) {
		String aspectannounce = "Invoked Method Afetr->" + jopo.getSignature().getName();
		System.out.println(aspectannounce);
	}
	
	@Around("log() && args(idparam)") //will apply for function have argument 
	public Object around(ProceedingJoinPoint pcejopo , long idparam ) throws Throwable{
		LOG.info("Around Before->" + pcejopo.getSignature().getName() + " with id " + idparam);
		Student student = (Student) pcejopo.proceed();
		LOG.info("Around after->" + student.getFirstName() + " " + student.getSurname());
		return student;
	}
	

}
