package com.zhenghao.spring.mybatis.proxy;

import java.lang.reflect.Proxy;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/12/04 22:25
 * MapperSession.java
 */

public class MapperSession {

	public static Object queryMapper(Class... clazz) {
		return Proxy.newProxyInstance(MapperSession.class.getClassLoader(), clazz, new MapperInvocationHandler());
	}
}
