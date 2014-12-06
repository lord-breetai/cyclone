package org.alfac.cyclone.web.faces.model;

import org.alfac.cyclone.web.faces.model.annotation.DataModelConfig;
import org.alfac.cyclone.web.faces.model.annotation.DataModelFilter;
import org.apache.deltaspike.core.api.provider.BeanManagerProvider;
import org.apache.deltaspike.core.util.BeanUtils;
import org.apache.deltaspike.core.util.StringUtils;
import org.apache.log4j.Logger;

import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan
 */
class DataModelConfigHandlerImpl<U> implements DataModelConfigHandler<U> {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(DataModelConfigHandlerImpl.class);

    private BeanManager beanManager = BeanManagerProvider.getInstance().getBeanManager();

    private DataModelConfigHandler<U> handler;

    private AnnotatedType<U> annotatedType;

    DataModelConfigHandlerImpl(DataModelConfigHandler<U> handler) {
        this.handler = handler;
    }

    @Override
    public DataModelConfig getDataModelConfig() {
        if (null == annotatedType) {
            initialize();
        }

        return BeanUtils.extractAnnotation(annotatedType, DataModelConfig.class);
    }

    @Override
    public Map<DataModelFilter, Object> getDataModelFilters() {
        if (null == annotatedType) {
            initialize();
        }

        return loadDataModelFilters(annotatedType);
    }

    @Override
    public Class<U> getDataModelConfigClass() {
        return handler.getDataModelConfigClass();
    }

    @Override
    public U getDataModelConfigInstance() {
        return handler.getDataModelConfigInstance();
    }

    private Map<DataModelFilter, Object> loadDataModelFilters(AnnotatedType<U> annotatedType) {
        Map<DataModelFilter, Object> filters = new HashMap<>();

        for (AnnotatedField<? super U> annotatedField : annotatedType.getFields()) {
            DataModelFilter filter = BeanUtils.extractAnnotation(annotatedField, DataModelFilter.class);
            if (null == filter) {
                continue;
            }

            Object filterValue = loadFilterValue(annotatedField.getJavaMember());
            if (null != filterValue) {
                if (!(filterValue instanceof String)) {
                    filters.put(filter, filterValue);
                } else {
                    if (!StringUtils.isEmpty((String) filterValue)) {
                        filters.put(filter, filterValue);
                    }
                }
            }
        }

        return filters;
    }

    private Object loadFilterValue(Field field) {
        U configInstance = getDataModelConfigInstance();

        field.setAccessible(true);

        Object filterValue = null;
        try {
            filterValue = field.get(configInstance);
        } catch (IllegalAccessException e) {
            LOG.warn("Unable to load a filter value ", e);
        }

        return filterValue;
    }

    private void initialize() {
        annotatedType = beanManager.createAnnotatedType(getDataModelConfigClass());
    }
}
