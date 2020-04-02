package com.example.demo.exam;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component // 알아서 잘 스캔해줘
public class BitAdvice {
	@Pointcut("execution(public * com.example.demo.exam..*(..))")
	public void cmethod() {}
	@Before("cmethod()")
	public void before() {
		System.out.println("컨트롤러 동작하기 전");
	}
}
