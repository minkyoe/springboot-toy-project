package com.minkyoe.project.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // posts 테이블에 insert / update 쿼리 실행
        // id값이 있다면 update, 없다면 insert 쿼리가 실행됨
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("mkmk@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll(); // posts 테이블에 있는 모든 데이터를 조회함

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }
}
