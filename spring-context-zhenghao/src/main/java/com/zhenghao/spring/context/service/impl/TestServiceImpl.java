package com.zhenghao.spring.context.service.impl;

import com.zhenghao.spring.context.service.TestService;
import org.springframework.stereotype.Component;

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
	@Override
	public void query() {
		System.out.println("query---------------------");
	}
}
