package com.zhenghao.spring.context.cglib;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 🙃
 * 🙃 通过cglib 增强被代理类，让每次调用目标类的方法时候都先来这个方法
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/11/30 15:26
 * MethodInterceptorCallback.java
 */

public class MethodInterceptorCallback implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("Interceptor cglib");
		// cglib 是基于父类继承来实现的，所以这里调用super来执行目标对象的方法
		methodProxy.invokeSuper(o, objects);
		return null;
	}
}
