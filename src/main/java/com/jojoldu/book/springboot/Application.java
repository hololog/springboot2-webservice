package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링부트, 스프링 Bean 읽기와 생성을 모두 자동설정 이 위치부터 설정을 읽어나가기 때문에 프로젝트최상단에 위치해야함
public class Application {//프로젝트의 메인클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장WAS실행 메소드
    }
}
