package com.minkyoe.project.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Posts클래스로 Database를 접근하게 해줄 JpaRepository
// Dao 역할 (DB Layer 접근자)
// 인터페이스 생성 후 JpaRepository<Entity 클래스, PK타입> 상속 -> CRUD 메소드 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
