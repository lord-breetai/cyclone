package org.alfac.cyclone.framework.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan
 */
public final class JPAEntityUtil {

    private JPAEntityUtil() {
    }

    public static <ID extends Serializable, U extends JPAEntity<ID>> List<ID> loadIds(List<U> elements) {
        List<ID> result = new ArrayList<>();

        if (null == elements) {
            return result;
        }

        for (U element : elements) {
            result.add(element.getId());
        }

        return result;
    }
}
