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
 * 为什么这个类能替换 web.xml？
 * web.xml 作用能在 tomcat 启动的时候 执行 web.xml
 * 那么这个类起码要跟 web.xml 一样在 tomcat 启动时被执行
 *
 * 那么为什么不相干的两个包，tomcat 能在启动的时候调用这个类的 onStartup 方法？下面开始做出解释
 *
 * 总结web容器 servlet 规范
 * 为什么 tomcat 、jetty 能成为 web容器 ？
 * 因为 tomcat 、jetty 都实现了 servlet 规范
 * 在 tomcat7 之前都是实现 servlet < 3.0 版本
 * 在 tomcat8 开始实现 servlet > 3.0
 * servlet > 3.0 版本提出一个特别的规范：
 * 如果当前项目的 classpath 下面 提供了一个 META-INF 文件夹，还提供了一个 services 文件夹，
 * 在这个文件夹下面还提供了一个 javax.servlet.ServletContainerInitializer 文件，在这个文件里面写一个类，
 * 如果他这个类 SpringServletContainerInitializer 实现了 ServletContainerInitializer 这个接口，
 * 那么容器在启动的时候必须调用 SpringServletContainerInitializer 类的 onStartup() 方法
 *
 * org.springframework.web.SpringServletContainerInitializer 这个类为什么会调用 WebApplicationInitializer 接口的实现？
 * servlet > 3.0 版本还提出一个规范：
 * 如果 org.springframework.web.SpringServletContainerInitializer 这个类上面有注解 @HandlesTypes(WebApplicationInitializer.class)
 * 那么会将 @HandlesTypes 注解填入的 接口类 当作 onStartup() 方法中的参数传进来
 * 因此在这里 spring 在这个类 SpringServletContainerInitializer 的 onStartup() 方法中循环 WebApplicationInitializer 接口实现
 * 并调用 WebApplicationInitializer 的 onStartup() 方法，因此本类中的 onStartup() 方法被调用
 * 所以在 tomcat 容器启动的时候可以调用这个方法
 *
 * 在spring boot 中，tomcat 已经发布了一个 内嵌的 embed 包，只要引入这个包，实例化 tomcat 对象 然后 .start 就可以启动 tomcat
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
		// 开始 初始化 spring
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		// 这里将 AppConfig 注册到 spring 已经开始扫描 AppConfig 中配置的包 扫描业务类（dao、service）和 扫描 controller，
		// 因此 applicationContext.xml 和 spring-mvc.xml 直接废弃
		ac.register(AppConfig.class);
		ac.refresh();
		// 结束 初始化 spring

		// Create and register the DispatcherServlet
		// 注册 servlet
		DispatcherServlet servlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/app/*");
	}
}
