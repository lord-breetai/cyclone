package org.alfac.cyclone.web.faces.model;

import org.alfac.cyclone.persistence.JPAEntity;
import org.apache.deltaspike.core.util.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.model.SortOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ivan
 */
public abstract class PagedDataModel<T extends JPAEntity, U> extends BaseDataModel<T, U> {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(PagedDataModel.class);

    private Map<String, T> dataCache;

    private Map<String, Integer> dataIndexCache;

    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        initialize();

        QueryResult<T> queryResult = loadFromDatabase(first, pageSize, sortField, sortOrder);
        List<T> elements = queryResult.getResultList();
        setRowCount(queryResult.getTotalCount());

        Integer dataIndex = 0;
        for (T element : elements) {
            String rowKey = encodeRowKey(element);

            if (!StringUtils.isEmpty(rowKey)) {
                dataCache.put(rowKey, element);
                dataIndexCache.put(rowKey, dataIndex);

                dataIndex++;
            }
        }

        return elements;
    }

    @Override
    public T getRowData(String rowKey) {
        return dataCache.get(rowKey);
    }

    @Override
    public Object getRowKey(T object) {
        return encodeRowKey(object);
    }

    protected String encodeRowKey(T t) {
        if (null == t.getId()) {
            return null;
        }

        return t.getId().toString();
    }

    private void initialize() {
        dataCache = new HashMap<>();
        dataIndexCache = new HashMap<>();
    }
}
