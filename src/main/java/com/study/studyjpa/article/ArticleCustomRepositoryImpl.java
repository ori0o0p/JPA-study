package com.study.studyjpa.article;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
class ArticleCustomRepositoryImpl implements ArticleCustomRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Stream<Article> findAllNonDeletedArticles() {
        var session = entityManager.unwrap(Session.class);
        session.enableFilter("deleteArticle").setParameter("isDeleted", false);

        try {
            return entityManager.createQuery("SELECT a FROM Article a", Article.class)
                    .getResultStream();
        } finally {
            session.disableFilter("deleteArticle");
        }
    }
}
