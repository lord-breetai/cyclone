package org.alfac.cyclone.framework.persistence;

import java.io.Serializable;

/**
 * @author Ivan
 */
public interface JPAEntity<ID extends Serializable> extends Serializable {

    ID getId();
}
