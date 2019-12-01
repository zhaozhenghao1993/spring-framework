package com.zhenghao.spring.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/12/01 21:43
 * TestMapper.java
 */

public interface TestMapper {

	@Select("SELECT * FROM test")
	List<Map<String, Object>> list();
}
