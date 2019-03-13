package com.demo.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@ServletComponentScan
public class QuoteManagerApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

//	public static void main(String[] args) {
//		SpringApplication.run(QuoteManagerApplication.class, args);
//	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){

		return application.sources(QuoteManagerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(QuoteManagerApplication.class, args);
	}

}
