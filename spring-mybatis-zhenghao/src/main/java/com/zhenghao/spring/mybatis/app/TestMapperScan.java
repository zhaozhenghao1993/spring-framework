package com.zhenghao.spring.mybatis.app;

import com.zhenghao.spring.mybatis.register.MapperImportBeanDefinitionRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(MapperImportBeanDefinitionRegister.class)
public @interface TestMapperScan {
}
