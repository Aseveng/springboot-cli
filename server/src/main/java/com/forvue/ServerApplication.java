package com.forvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class ServerApplication {


	public CorsConfiguration buildConfig(){

		//跨域
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
		corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
		corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
//		corsConfiguration.addExposedHeader(CorsConfiguration.ALL);

//		getResponseHeader()可返回的值（在web端获取ajax request的response中的自定义的header值，必须addExposedHeader

		return corsConfiguration;
	}
	/**
	 * 跨域过滤器
	 * 注册到注册中心时，需要注释掉该方法。
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = buildConfig();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
