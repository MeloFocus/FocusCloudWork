package com.focus.notice;

import com.focus.framework.annotation.EnableFocusCloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication()
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.focus") //扫描base服务接口所在的包，feign才能成功调用base接口
@EnableFocusCloud

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
