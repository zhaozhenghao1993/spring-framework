package com.zhenghao.spring.mybatis.register;

import com.zhenghao.spring.mybatis.factory.TestFactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/12/04 22:54
 * MapperImportBeanDefinitionRegister.java
 */

public class MapperImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(TestFactoryBean.class);
		AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		// 获取到这个 TestFactoryBean 里面的所有属性的值，并且往里扔一个值
		beanDefinition.getPropertyValues().add("mapperInterface", "com.zhenghao.spring.mybatis.dao.TestMapper");
		registry.registerBeanDefinition("testFactoryBean", beanDefinition);
	}
}
