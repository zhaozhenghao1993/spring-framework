package com.zhenghao.spring.context.service.impl;

import com.zhenghao.spring.context.service.DemoService;
import com.zhenghao.spring.context.service.TestService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/11/05 22:31
 * TestServiceImpl.java
 */
@Component
public class TestServiceImpl implements TestService {

	@Resource
	private DemoService demoService;

	@Override
	public void query() {
		System.out.println("query---------------------");
	}
}
