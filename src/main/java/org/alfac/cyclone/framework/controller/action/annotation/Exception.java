package org.alfac.cyclone.framework.controller.action.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ivan
 */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface Exception {
    Class<? extends java.lang.Exception> clazz();

    String message() default "";

    String[] update() default {};

    String[] execute() default {};
}
