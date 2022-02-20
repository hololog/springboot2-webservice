package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {//Posts클래스로 DB를 접근하게 해줄 JpaRepository
}
//보통 MyBatis등에서 Dao라과 불리는 DB Layer접근자와 유사
//JpaRepository<Entity클래스,pk타입> 인터페이스를 상속하면 기본적인 CRUD메소드가 자동으로 생성
//
