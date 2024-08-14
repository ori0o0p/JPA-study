package com.study.studyjpa.article;

record ArticleResponse(
        Long articleId,
        String title,
        String content,
        Article.DateTime dateTime
) {
    public static ArticleResponse fromEntity(Article article) {
        return new ArticleResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getDateTime()
        );
    }
}
