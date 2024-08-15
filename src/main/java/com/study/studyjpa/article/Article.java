package com.study.studyjpa.article;

import com.study.studyjpa.common.annotation.ValueObject;
import com.study.studyjpa.common.converter.BooleanToYNConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * - pk: `GenerationType.IDENTITY`를 사용하여 기본키 생성을 DBMS에게 위임.
 */

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
/* 상속 매핑 전략 */
@Inheritance(strategy = InheritanceType.JOINED)
/* 엔티티 타입 구분 컬럼 */
@DiscriminatorColumn(name = "type")
abstract class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @Embedded
    private DateTime dateTime;

    @Convert(converter = BooleanToYNConverter.class)
    private Boolean isPublished;

    @ValueObject
    record DateTime(
            @CreationTimestamp LocalDateTime createdAt,
            @UpdateTimestamp LocalDateTime updatedAt
    ) {}
}
