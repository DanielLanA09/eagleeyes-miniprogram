package com.eagleshing.miniprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.eagleshing.miniprogram.property.FileStorageProperties;

@EnableConfigurationProperties({FileStorageProperties.class})
@SpringBootApplication
@MapperScan("com.eagleshing.miniprogram.domain.mappers")
public class EagleEyeWxApplication {
	public static void main(String[] args) {
		SpringApplication.run(EagleEyeWxApplication.class, args);
	}
}
