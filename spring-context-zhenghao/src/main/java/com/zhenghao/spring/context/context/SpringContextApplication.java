package com.zhenghao.spring.context.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 🙃 org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory 的 initializeBean
 * 🙃 在这里调用 ApplicationContextAwareProcessor 的 postProcessBeforeInitialization 方法
 * 	  让实现 ApplicationContextAware 的 bean 执行 setApplicationContext 方法，可以把 applicationContext 扔出去
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/11/07 22:10
 * StringCotextApplication.java
 */

@Component
public class SpringContextApplication implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
