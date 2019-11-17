package com.zhenghao.spring.context.processor;

import com.zhenghao.spring.context.aop.TestInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 🙃
 * 🙃 BeanPostProcessor 会干预 bean 的初始化过程，不会干预 bean 的实例化过程
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/11/05 22:33
 * TestBeanPostProcessor.java
 */
// @Component
public class TestBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("testServiceImpl")) {
			Class<?>[] interfaceClass = bean.getClass().getInterfaces();
			// 这里返回的 object 就是已经被代理的 bean 了
			Object object = Proxy.newProxyInstance(TestBeanPostProcessor.class.getClassLoader(),
					interfaceClass,
					new TestInvocationHandler(bean));
			return object;
		}
		return bean;
	}
}
