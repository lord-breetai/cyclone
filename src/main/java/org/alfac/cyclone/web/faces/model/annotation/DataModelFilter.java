package org.alfac.cyclone.web.faces.model.annotation;

import java.lang.annotation.*;

/**
 * @author Ivan
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface DataModelFilter {

    String filterName();

    String expression();
}
