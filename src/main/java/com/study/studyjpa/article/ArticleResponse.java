package com.study.studyjpa.article;

record ArticleResponse(
        Long articleId,
        Article.Content content
) {
    public static ArticleResponse fromEntity(Article article) {
        return new ArticleResponse(
                article.getId(),
                article.getContent()
        );
    }
}
