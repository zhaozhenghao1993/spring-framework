package com.zhenghao.spring.mybatis.service;

import com.zhenghao.spring.mybatis.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/12/02 22:45
 * TestService.java
 */

@Service
public class TestService {

	@Autowired
	private TestMapper testMapper;

	public void listTests() {
		System.out.println(testMapper.list());
	}
}
