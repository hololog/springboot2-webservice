package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class) //JUnit내장 실행자외의 스프링 실행자 즉, 스프링부트와 JUnit사이의 연결자 역할
@WebMvcTest
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 빈을 주입받음
    private MockMvc mvc; //스프링 mvc테스트의 시작점, 웹api를 테스트할때 사용

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc를 통해 /hello주소로 HTTP Get요청을 합니다
                .andExpect(status().isOk()) //mvc.perfor의 결과 검증, 200,404,500 isOK()는 200인지 아닌지 검증
                .andExpect(content().string(hello)); //응답본문의 내용 검증, 리턴값이 "hello"가 맞는지 검증
   }

    @Test
    public void  hellloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name) //API테스트에 사용할 요청 파라미터를 설정
                        .param("amount", String.valueOf(amount)))// 단, 문자열만 가능
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //json응답값을 필드별로 검증하는 메소드
                .andExpect(jsonPath("$.amount", is(amount)));

    }

}

