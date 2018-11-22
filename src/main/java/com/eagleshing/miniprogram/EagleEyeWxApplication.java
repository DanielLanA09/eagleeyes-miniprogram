package com.eagleshing.miniprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.eagleshing.miniprogram.property.FileStorageProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableConfigurationProperties({FileStorageProperties.class})
@SpringBootApplication
@MapperScan("com.eagleshing.miniprogram.domain.mappers")
@EnableJpaAuditing
public class EagleEyeWxApplication extends SpringBootServletInitializer {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(EagleEyeWxApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EagleEyeWxApplication.class);
	}
}
