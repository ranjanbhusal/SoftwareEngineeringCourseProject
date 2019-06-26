package com.mumSched.controller;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect

public class myAspect {

	@Before ("execution(* com.mumSched.service.*(..))")
	public void getAllAdvice(Joinpoint joinpoint) {
		System.out.println(".......................................................................");
		System.out.println("Intercepted"+ joinpoint.toString());
	}
}
