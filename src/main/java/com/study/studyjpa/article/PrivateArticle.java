package com.study.studyjpa.article;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PRIVATE")
class PrivateArticle extends Article {
    @Column(length = 3)
    private Integer privateLevel;
}
