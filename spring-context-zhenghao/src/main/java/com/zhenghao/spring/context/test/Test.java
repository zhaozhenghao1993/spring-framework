package com.zhenghao.spring.context.test;

import com.zhenghao.spring.context.app.AppConfig;
import com.zhenghao.spring.context.cglib.MethodInterceptorCallback;
import com.zhenghao.spring.context.service.DemoService;
import com.zhenghao.spring.context.service.TestService;
import com.zhenghao.spring.context.service.configuration.DemoOneService;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/10/29 22:35
 * Test.java
 */

public class Test {
	public static void main(String[] args) {
		/**
		 * spring 有三种生命周期回调
		 * 可以同时存在，
		 * 顺序：先执行 @PostConstruct and @PreDestroy annotations 注解的
		 * 		再执行 InitializingBean DisposableBean 接口的
		 * 		最后执行 init() and destroy() methods XML的
		 * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
		 * #initializeBean(java.lang.String, java.lang.Object, org.springframework.beans.factory.support.RootBeanDefinition)
		 *
		 * As of Spring 2.5, you have three options for controlling bean lifecycle behavior:
		 *
		 * The InitializingBean and DisposableBean callback interfaces
		 *
		 * Custom init() and destroy() methods
		 *
		 * The @PostConstruct and @PreDestroy annotations. You can combine these mechanisms to control a given bean.
		 */
		/**
		 * 把类扫描出来
		 * 把 bean 实例化
		 */
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		TestService bean = (TestService) applicationContext.getBean("testService");
		bean.query();
		/*DemoService bean = applicationContext.getBean(DemoService.class);
		bean.test();*/

		// System.out.println(applicationContext.getBean(TestService.class));
		// System.out.println(applicationContext.getBean(DemoService.class));

		// --------------------cglib---------------------------
		/*Enhancer enhancer = new Enhancer();
		// 增强父类，cglib是基于继承来的
		enhancer.setSuperclass(DemoOneService.class);
		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
		// 过滤方法，给一个拦截器，每次都拦截这个方法
		enhancer.setCallback(new MethodInterceptorCallback());
		// 调用 create() 方法，然后向上转型，这里用代理类的父类 DemoOneService(目标类) 接收
		DemoOneService demoOneService = (DemoOneService) enhancer.create();
		demoOneService.query();*/
	}
}
