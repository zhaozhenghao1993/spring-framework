package com.zhenghao.spring.context.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/11/05 22:39
 * TestInvocationHandler.java
 */

public class TestInvocationHandler implements InvocationHandler {

	private Object object;

	public TestInvocationHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before aop -----------------------");
		// 这里的 object 就是被代理前的真实对象
		Object result = method.invoke(object);
		System.out.println("after aop -----------------------");
		return result;
	}
}
