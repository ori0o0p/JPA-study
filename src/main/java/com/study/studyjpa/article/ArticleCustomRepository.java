package com.study.studyjpa.article;

import java.util.stream.Stream;

interface ArticleCustomRepository {
    Stream<Article> findAllNonDeletedArticles();
}
