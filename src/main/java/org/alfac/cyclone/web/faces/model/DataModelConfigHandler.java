package org.alfac.cyclone.web.faces.model;

import org.alfac.cyclone.web.faces.model.annotation.DataModelConfig;
import org.alfac.cyclone.web.faces.model.annotation.DataModelFilter;

import java.util.Map;

/**
 * @author Ivan
 */
public interface DataModelConfigHandler<U> {

    DataModelConfig getDataModelConfig();

    Map<DataModelFilter, Object> getDataModelFilters();

    Class<U> getDataModelConfigClass();

    U getDataModelConfigInstance();
}
