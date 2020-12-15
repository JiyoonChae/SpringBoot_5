package com.iu.sb5.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageLocaleConfig implements WebMvcConfigurer {
	@Bean
	public LocaleResolver localeResolver(){
		
		//session 이용
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.KOREAN);
		
		return sessionLocaleResolver;
	}
	
	//이미 있는 interceptor class 객체 생성
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		//parameter받아서 언어를 구분
		localeChangeInterceptor.setParamName("lang");
		
		return localeChangeInterceptor;
	}
	
	//LocaleChangeInterceptor 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor())
		.addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
