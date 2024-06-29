package com.ivan.spring.selenium.kelvin.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

/**
 * Indicates that a configuration class will be lazily initialized.
 * The beans defined in a class annotated with `@LazyConfiguration` will not be created and initialized at application startup,
 * but only when they are first needed.
 * This can be useful to speed up application startup by avoiding the initialization of beans that might not be needed.
 * It can also be used to handle beans that require some specific initialization parameters that are only available after the application has started.
 *
 * @author ivanKuleshin
 */
@Lazy
@Configuration
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LazyConfiguration {
}