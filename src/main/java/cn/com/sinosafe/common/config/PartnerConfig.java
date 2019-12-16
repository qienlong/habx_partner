package cn.com.sinosafe.common.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * 系统初始化 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年6月19日<br>
 */
@Configuration
public class PartnerConfig {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
