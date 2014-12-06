package org.alfac.cyclone.web.faces.model;

import org.alfac.cyclone.web.faces.model.annotation.DataModelConfig;
import org.alfac.cyclone.web.faces.model.annotation.DataModelFilter;
import org.apache.deltaspike.core.util.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ivan
 */
abstract class BaseDataModel<T, U> extends LazyDataModel<T> implements DataModelConfigHandler<U> {

    private DataModelConfigHandler<U> handlerImpl = new DataModelConfigHandlerImpl<>(this);

    protected abstract ListService getListService();

    protected abstract Class<T> getEntityClass();

    protected QueryResult<T> loadFromDatabase(int first, int pageSize, String sortField, SortOrder sortOrder) {
        DataModelConfig dataModelConfig = handlerImpl.getDataModelConfig();

        Map<DataModelFilter, Object> filters = handlerImpl.getDataModelFilters();

        String where = buildWhere(new ArrayList<>(filters.keySet()));
        String orderBy = buildOrderBy(sortField, sortOrder);

        Map<String, Object> filterMap = buildFiltersMap(filters);

        String selectQL = dataModelConfig.selectJpaQL() + where + orderBy;
        String countQL = dataModelConfig.countJpaQL() + where;

        return getListService().loadElements(getEntityClass(), first, pageSize, selectQL, countQL, filterMap);
    }

    private String buildOrderBy(String sortField, SortOrder sortOrder) {
        if (StringUtils.isEmpty(sortField) || SortOrder.UNSORTED.equals(sortOrder)) {
            return "";
        }

        String order = " asc";
        if (SortOrder.DESCENDING.equals(sortOrder)) {
            order = " desc";
        }

        return new StringBuilder(" order by ")
                .append(sortField)
                .append(order)
                .toString();
    }

    private Map<String, Object> buildFiltersMap(Map<DataModelFilter, Object> source) {
        Map<String, Object> result = new HashMap<>();

        for (DataModelFilter dataModelFilter : source.keySet()) {
            Object value = source.get(dataModelFilter);

            result.put(dataModelFilter.filterName(), value);
        }

        return result;
    }

    private String buildWhere(List<DataModelFilter> filters) {
        if (filters.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder(" where ");

        for (int i = 0; i < filters.size(); i++) {
            DataModelFilter filter = filters.get(i);
            builder.append(filter.expression());

            if (i < (filters.size() - 1)) {
                builder.append(" and ");
            }
        }

        return builder.toString();
    }

    @Override
    public DataModelConfig getDataModelConfig() {
        throw new UnsupportedOperationException("This method is not supported");
    }

    @Override
    public Map<DataModelFilter, Object> getDataModelFilters() {
        throw new UnsupportedOperationException("This method is not supported");
    }
}
