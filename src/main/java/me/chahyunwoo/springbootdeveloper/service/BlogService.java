package me.chahyunwoo.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.chahyunwoo.springbootdeveloper.domain.Article;
import me.chahyunwoo.springbootdeveloper.dto.AddArticleRequest;
import me.chahyunwoo.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 데이터베이스에 저장된 글 모두 가져오는 메서드
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    // 데이터베이스에 저장되어 있는 글의 ID를 이용해 글을 조회하는 메서드
    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }

    // 데이터베이스에서 데이터를 삭제하는 메서드
    public void delete(long id){
        blogRepository.deleteById(id);
    }
}
