package com.ivan.spring.selenium.kelvin.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to indicate that a bean should be scoped to the "threadLocalScope".
 * This is a custom scope used for managing WebDriver instances for different browsers.
 * Beans annotated with `@ThreadScopeBean` will have their lifecycle managed according to the rules defined in the "threadLocalScope" scope.
 *
 * @author ivanKuleshin
 */
@Bean
@Scope("threadLocalScope")
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadLocalBean {
}
