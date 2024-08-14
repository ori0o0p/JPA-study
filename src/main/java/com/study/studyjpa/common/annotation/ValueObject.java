package com.study.studyjpa.common.annotation;

import jakarta.persistence.Embeddable;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Embeddable
public @interface ValueObject {
}
