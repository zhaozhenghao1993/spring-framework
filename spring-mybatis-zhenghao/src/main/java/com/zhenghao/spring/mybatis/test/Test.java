package com.zhenghao.spring.mybatis.test;

import com.zhenghao.spring.mybatis.app.AppConfig;
import com.zhenghao.spring.mybatis.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/12/02 22:56
 * Test.java
 */

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		TestService testService = annotationConfigApplicationContext.getBean(TestService.class);
		testService.listTests();
	}
}
