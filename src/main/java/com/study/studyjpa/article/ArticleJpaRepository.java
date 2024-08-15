package com.study.studyjpa.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

interface ArticleJpaRepository extends JpaRepository<Article, Long> {
    @Query("SELECT p FROM Article p WHERE TYPE(p) = :type")
    Stream<Article> findArticlesByType(@Param("type") Class<? extends Article> type);
}
