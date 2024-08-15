package com.study.studyjpa.article;

import java.util.List;

interface ArticleUseCase {
    void writePrivate(String title, String content, Integer privateLevel);
    void writeGeneral(String title, String content, Integer generalLevel);
    List<ArticleResponse> getAll();
    List<ArticleResponse> getAllByType(String type);
    List<ArticleResponse> getAllByNonDeleted();
}
