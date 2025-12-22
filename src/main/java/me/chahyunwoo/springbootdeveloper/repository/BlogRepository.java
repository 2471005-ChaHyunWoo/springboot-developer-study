package me.chahyunwoo.springbootdeveloper.repository;

import me.chahyunwoo.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
