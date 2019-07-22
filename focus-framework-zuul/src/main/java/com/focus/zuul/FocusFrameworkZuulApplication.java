package com.focus.zuul;

import com.focus.zuul.config.HeaderDeliverFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class FocusFrameworkZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(FocusFrameworkZuulApplication.class, args);
	}

	/**
	 * 注入自定义过滤器，向下游服务添加认证信息header
	 * @return
	 */
	/*@Bean
	public HeaderDeliverFilter headerDeliverFilter(){
		return new HeaderDeliverFilter();
	}*/

}
