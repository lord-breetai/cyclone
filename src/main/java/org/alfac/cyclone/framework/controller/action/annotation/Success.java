package org.alfac.cyclone.framework.controller.action.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ivan
 */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface Success {
    String message() default "";

    String[] update() default {};

    String[] execute() default {};
}
