package com.zhenghao.spring.context.test;

import com.zhenghao.spring.context.app.AppConfig;
import com.zhenghao.spring.context.service.DemoService;
import com.zhenghao.spring.context.service.TestService;
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
		 * 把类扫描出来
		 * 把 bean 实例化
		 */
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(applicationContext.getBean(TestService.class));
		// System.out.println(applicationContext.getBean(DemoService.class));

		/**
		 *
		 */
	}
}
