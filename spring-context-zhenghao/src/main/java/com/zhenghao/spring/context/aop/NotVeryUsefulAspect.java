package com.zhenghao.spring.context.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 🙃
 * 🙃 简易 AOP
 * 🙃 AOP 作用了一个对象，相当于改变了这个对象-----------proxy
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/11/17 21:54
 * NotVeryUsefulAspect.java
 */

@Component
@Aspect
public class NotVeryUsefulAspect {

	@Pointcut("execution(* com.zhenghao.spring.context.service.impl.TestServiceImpl.*(..))") // the pointcut expression
	private void anyPublicMethod() {} // the pointcut signature

	@Before("anyPublicMethod()")
	public void before() {
		System.out.println("--------------------aop---------------------");
	}
}
