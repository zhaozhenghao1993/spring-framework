package com.zhenghao.spring.mybatis.factory;

import com.zhenghao.spring.mybatis.dao.TestMapper;
import com.zhenghao.spring.mybatis.proxy.MapperSession;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 🙃
 * 🙃 FactoryBean 首先 自己本身是一个 bean
 * 		然后 调用 getObject() 会再产生一个 bean
 * 		所以 FactoryBean 会产生两个 bean
 *
 * 	ac.getBean("testFactoryBean") 只能拿到 getObject() 方法里面产生的 bean 对象
 * 	ac.getBean("&testFactoryBean") 前面只有加&才能拿到他自己
 *
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/12/04 22:04
 * TestFactoryBean.java
 */

// @Component
public class TestFactoryBean implements FactoryBean {

	private Class mapperInterface;

	@Override
	public Object getObject() throws Exception {
		Object object = MapperSession.queryMapper(mapperInterface);
		return object;
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}

	public void setMapperInterface(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}
}
