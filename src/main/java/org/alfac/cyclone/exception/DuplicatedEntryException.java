package org.alfac.cyclone.exception;

import javax.ejb.ApplicationException;

/**
 * @author Ivan
 */
@ApplicationException(rollback = true)
public class DuplicatedEntryException extends RuntimeException {
}
