package org.alfac.cyclone.web.faces.model.annotation;

import java.lang.annotation.*;

/**
 * @author Ivan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface DataModelConfig {

    String selectJpaQL();

    String countJpaQL();
}
