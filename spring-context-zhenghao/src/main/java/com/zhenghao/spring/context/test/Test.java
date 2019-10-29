package com.zhenghao.spring.context.test;

import com.zhenghao.spring.context.app.AppConfig;
import com.zhenghao.spring.context.service.TestService;
import org.springframework.context.ApplicationContext;
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
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(applicationContext.getBean(TestService.class));
	}
}
