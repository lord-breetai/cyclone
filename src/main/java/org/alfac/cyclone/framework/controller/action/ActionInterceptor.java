package org.alfac.cyclone.framework.controller.action;

import org.alfac.cyclone.framework.controller.action.annotation.Action;
import org.apache.deltaspike.core.util.AnnotationUtils;
import org.apache.log4j.Logger;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * @author Ivan
 */
@Action
@Interceptor
public class ActionInterceptor implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(ActionInterceptor.class);

    @Inject
    private BeanManager beanManager;

    @Inject
    private SuccessHandler successHandler;

    @Inject
    private ErrorHandler errorHandler;

    @AroundInvoke
    public Object aroundInvoke(final InvocationContext invocationContext) throws Exception {

        Action annotation = AnnotationUtils.extractAnnotationFromMethod(beanManager, invocationContext.getMethod(), Action.class);
        if (null == annotation) {
            throw new RuntimeException("Unable to execute the method: " + invocationContext.getMethod().getName());
        }

        Object result = null;
        try {
            result = invocationContext.proceed();

            successHandler.handle(annotation.onSuccess());
        } catch (Exception e) {
            if (0 == annotation.onError().length) {
                throw e;
            }

            org.alfac.cyclone.framework.controller.action.annotation.Exception exceptionAnnotation = findExceptionAnnotation(annotation, e.getClass());
            if (null == exceptionAnnotation) {
                throw e;
            }

            errorHandler.handle(exceptionAnnotation, e);
        }

        return result;
    }

    private org.alfac.cyclone.framework.controller.action.annotation.Exception findExceptionAnnotation(Action actionAnnotation, Class<? extends Exception> clazz) {
        for (org.alfac.cyclone.framework.controller.action.annotation.Exception annotation : actionAnnotation.onError()) {
            if (annotation.clazz().equals(clazz)) {
                return annotation;
            }
        }

        return null;
    }
}
