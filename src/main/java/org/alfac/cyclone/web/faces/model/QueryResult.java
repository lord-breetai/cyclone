package org.alfac.cyclone.web.faces.model;

import java.util.List;

/**
 * @author Ivan
 */
public class QueryResult<T> {

    private int totalCount;

    private List<T> resultList;

    public QueryResult(int totalCount, List<T> resultList) {
        this.totalCount = totalCount;
        this.resultList = resultList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<T> getResultList() {
        return resultList;
    }
}
