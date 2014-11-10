package org.alfac.cyclone.common.persistence;

import java.io.Serializable;

/**
 * @author Ivan
 */
public interface JPAEntity<ID> extends Serializable {

    ID getId();
}
