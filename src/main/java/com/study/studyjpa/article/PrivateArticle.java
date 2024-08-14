package com.study.studyjpa.article;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@DiscriminatorValue("PRIVATE")
class PrivateArticle extends Article {
    @Column(length = 3)
    private Integer privateLevel;

    protected PrivateArticle() {}
}
