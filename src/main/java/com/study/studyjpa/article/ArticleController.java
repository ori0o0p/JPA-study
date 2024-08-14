package com.study.studyjpa.article;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
class ArticleController {
    private final ArticleUseCase articleUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void write(@RequestBody WriteArticleRequest request) {
        if (request.type.equals(WriteArticleRequest.Type.PRIVATE.name())) {
            articleUseCase.writePrivate(request.title, request.content, request.level);
        } else {
            articleUseCase.writeGeneral(request.title, request.content, request.level);
        }
    }

    @GetMapping
    ListDataResponse<ArticleResponse> getAll() {
        final var data = articleUseCase.getAll();

        return new ListDataResponse<>(data);
    }

    record ListDataResponse<T>(List<T> data) {}

    record WriteArticleRequest(String title, String content, String type, Integer level) {
        enum Type {
            PRIVATE, GENERAL
        }
    }
}
