package com.zhenghao.spring.context.service.configuration;

/**
 * 🙃
 * 🙃 测试 @Configuration 作用
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/11/28 22:47
 * DemoOneService.java
 */

public class DemoOneService {

	public DemoOneService() {
		System.out.println("DemoOneService  init");
	}

	public String query() {
		System.out.println("DemoOneService ===> query");
		return "DemoOneService ===> query";
	}
}
