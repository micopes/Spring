package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// SpringBootApplication을 띄우면서 tomcat이라는 웹서버가 내장되어 있어 같이 올라오게 된다.
	// 실행 후 localhost:8080으로 확인 가능.
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
