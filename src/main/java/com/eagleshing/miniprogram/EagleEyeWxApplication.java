package com.eagleshing.miniprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.eagleshing.miniprogram.property.FileStorageProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableConfigurationProperties({FileStorageProperties.class})
@SpringBootApplication
@MapperScan("com.eagleshing.miniprogram.domain.mappers")
public class EagleEyeWxApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(EagleEyeWxApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EagleEyeWxApplication.class);
	}
}
