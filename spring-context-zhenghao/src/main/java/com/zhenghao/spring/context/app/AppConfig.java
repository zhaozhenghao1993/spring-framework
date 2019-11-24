package com.zhenghao.spring.context.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 🙃 @EnableAspectJAutoProxy 开启 AOP 就是这个注解 将处理 AOP 的 BeanPostProcessor 注册到 spring 中
 * 🙃 AnnotationAwareAspectJAutoProxyCreator.class
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/10/29 22:32
 * AppConfig.java
 */
@Configuration
@ComponentScan("com.zhenghao.spring.context")
@EnableAspectJAutoProxy
public class AppConfig {
}
