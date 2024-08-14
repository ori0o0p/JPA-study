package com.study.studyjpa.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
class ArticleService implements ArticleUseCase {
    private final ArticleRepository articleRepository;

    @Override
    public void writePrivate(String title, String content, Integer privateLevel) {
        save(PrivateArticle.builder()
                .title(title)
                .content(content)
                .privateLevel(privateLevel)
                .build());
    }

    @Override
    public void writeGeneral(String title, String content, Integer generalLevel) {
        save(GeneralArticle.builder()
                .title(title)
                .content(content)
                .generalLevel(generalLevel)
                .build());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArticleResponse> getAll() {
        return articleRepository.findAll()
                .stream()
                .map(ArticleResponse::fromEntity)
                .toList();
    }

    private Article save(Article article) {
        return articleRepository.save(article);
    }
}
