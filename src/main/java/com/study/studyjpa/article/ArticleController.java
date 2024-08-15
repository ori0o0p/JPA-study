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
            articleUseCase.writePrivate(request.title, request.description, request.level);
        } else {
            articleUseCase.writeGeneral(request.title, request.description, request.level);
        }
    }

    @GetMapping
    ListDataResponse<ArticleResponse> getAll() {
        final var data = articleUseCase.getAll();

        return new ListDataResponse<>(data);
    }

    @GetMapping("/{type}")
    ListDataResponse<ArticleResponse> getAllByType(@PathVariable String type) {
        final var data = articleUseCase.getAllByType(type);

        return new ListDataResponse<>(data);
    }

    record ListDataResponse<T>(List<T> data) {}

    record WriteArticleRequest(String title, String description, String type, Integer level) {
        enum Type {
            PRIVATE, GENERAL
        }
    }
}
