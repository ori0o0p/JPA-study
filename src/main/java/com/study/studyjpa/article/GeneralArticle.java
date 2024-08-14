package com.study.studyjpa.article;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GENERAL")
class GeneralArticle extends Article {
    @Column(length = 3)
    private Integer generalLevel;
}
