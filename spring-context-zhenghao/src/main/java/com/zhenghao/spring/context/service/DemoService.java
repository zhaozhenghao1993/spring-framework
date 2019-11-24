package com.zhenghao.spring.context.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/10/29 22:37
 * TestService.java
 */
@Component
public class DemoService {

	@Autowired
	private TestService testServiceImpl;

	public void test() {
		testServiceImpl.query();
	}
}
