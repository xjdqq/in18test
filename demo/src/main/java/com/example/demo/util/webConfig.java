package com.example.demo.util;


import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class webConfig implements WebMvcConfigurer {

    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // 所有的当前站点的请求地址，都支持跨域访问。
//                .allowedOrigins("*") // 所有的外部域都可跨域访问。 如果是localhost则很难配置，因为在跨域请求的时候，外部域的解析可能是localhost、127.0.0.1、主机名
////                .allowCredentials(true) // 是否支持跨域用户凭证
//                .allowedMethods(ORIGINS) // 当前站点支持的跨域请求类型是什么
//                .maxAge(3600); // 超时时长设置为1小时。 时间单位是秒。
//    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        MyLocaleInterceptor localeChangeInterceptor = new MyLocaleInterceptor();
        //自定义参数
        localeChangeInterceptor.setParamName("Accept-Language");
        return localeChangeInterceptor;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        //指定默认语言为中文
        localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return localeResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setUseCodeAsDefaultMessage(false);
        resourceBundleMessageSource.setDefaultEncoding("utf-8");
        resourceBundleMessageSource.setBasenames("i18n/language");
        return resourceBundleMessageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setProviderClass(HibernateValidator.class);
        validatorFactoryBean.getValidationPropertyMap().put("hibernate.validator.fail_fast", "false");
        validatorFactoryBean.setValidationMessageSource(messageSource());
        return validatorFactoryBean;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
