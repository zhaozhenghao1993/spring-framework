package com.zhenghao.spring.web.app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * 🙃
 * 🙃 传统的 构建 Servlet 需要在 web.xml 中写入<servlet> 或者 @WebServlet 注解
 *    在 spring 中 还有第三种注册 Servlet 的方法就是 在代码中 注册 一个实例化后的 Servlet
 *    这样在 spring boot 中就不需要 web.xml 的配置文件了
 *
 * 🙃 docs: https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-servlet
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/11/25 23:24
 * MyWebApplicationInitializer.java
 */

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCxt) {
		// servletCxt 就相当于 tomcat jetty

		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();

		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/app/*");
	}
}
