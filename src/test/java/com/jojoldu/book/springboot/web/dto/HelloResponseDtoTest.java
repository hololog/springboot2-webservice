package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_데스트() {
        //given(준비)
        String name = "test";
        int amount = 1000;

        //when(실행)
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then(검증)
        assertThat(dto.getName()).isEqualTo(name); //assertThat() => assertj라는 테스트검증 라이브러리의 메소드, 검증하고 싶은 대상을 인자로 받는다
        assertThat(dto.getAmount()).isEqualTo(amount); //isEqualTo() => assertj 라이브러리의 동등비교메서드
    }
}
