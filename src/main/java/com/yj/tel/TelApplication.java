package com.yj.tel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yj.tel")
public class TelApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelApplication.class, args);
	}

}
