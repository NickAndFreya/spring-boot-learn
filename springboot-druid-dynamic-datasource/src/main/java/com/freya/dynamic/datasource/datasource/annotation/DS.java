package com.freya.dynamic.datasource.datasource.annotation;


import com.freya.dynamic.datasource.datasource.SourceName;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DS {
    String value() default SourceName.FIRST;
}
