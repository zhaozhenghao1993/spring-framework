package com.zhenghao.spring.mybatis.proxy;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/12/04 22:23
 * MapperInvocationHandler.java
 */

public class MapperInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("connect db");
		Select annotation = method.getAnnotation(Select.class);
		if (annotation != null) {
			String s = annotation.value()[0];
			System.out.println(s);
		}

		if ("toString".equals(method.getName())) {
			return proxy.getClass().getInterfaces()[0].getName();
		}

		return null;
	}
}
