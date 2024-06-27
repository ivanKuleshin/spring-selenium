package com.ivan.spring.selenium.kelvin.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TakeScreenshot {
}
