package com.zhenghao.spring.context.processor;

import com.zhenghao.spring.context.service.DemoService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 🙃
 * 🙃 BeanFactoryPostProcessor 作用，在BeanDefinition 设置扫描好后，
 * 可以对 在BeanDefinition 的一些属性进行改变，比如 DemoService 并没有注册到Spring
 * 但是在这里修改 TestService 对应的Class配置
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/11/03 16:42
 * TestBeanFactoryPostProcessor.java
 */
// @Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition testServiceBeanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("testService");
		System.out.println(testServiceBeanDefinition.getBeanClassName());
		testServiceBeanDefinition.setBeanClass(DemoService.class);
	}
}
