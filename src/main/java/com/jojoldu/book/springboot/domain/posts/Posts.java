package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Getter //6. 클래스내 모든 필드의 Getter메소드 자동 생성
// setter는 생성하지 않는다=> 인스턴스값들이 언제 어디서 변경되는지 명확하게 구분하기 힘들어서
// 대신 해당 필드의 값변겅이 필요하면 구체적인 목적과 의도를 알수있도록 메소드를 추가해서 변경
@NoArgsConstructor // 5.기본생성자 자동추가
@Entity //1.테이블과 링크될 클래임을 나타내는 어노테이션
public class Posts {

    @Id //2.해당 테이블의 pk필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //3.pk생성규칙
    private Long id;

    @Column(length = 500, nullable = false) //4.테이블의 칼럼, 선언하지않아도 자동으로 클래스의 필드는 테이블의 컬럼이되지만 옵션설정을 위해 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder// 7. 생성자 상단에 선언시 생상자에 포함된 필드만 빌더 패턴 클래스 생성
    //db에 insert할때 생성자나 빌더 클래스를 사용 다만 빌더클래스가 채워야할 필드를 더 명확히 지정할수 있다
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
