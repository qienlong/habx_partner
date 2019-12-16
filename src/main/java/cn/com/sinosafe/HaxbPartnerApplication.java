package cn.com.sinosafe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author hirson
 */
@SpringCloudApplication
@MapperScan("cn.com.sinosafe.dao")
@EnableHystrix
@EnableFeignClients
@EnableAsync(proxyTargetClass=true)
public class HaxbPartnerApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(HaxbPartnerApplication.class, args);
	}

}
