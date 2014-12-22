package org.alfac.cyclone.framework.controller.action;

import org.alfac.cyclone.web.faces.utils.Messages;
import org.apache.deltaspike.core.util.StringUtils;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Ivan
 */
@Named
public class ErrorHandler implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(ErrorHandler.class);

    @Inject
    private RequestContextManager requestContextManager;

    @Inject
    private Messages messages;

    public <U extends Exception> void handle(org.alfac.cyclone.framework.controller.action.annotation.Exception annotation, U exception) {
        LOG.debug("Handling the exception " + exception);

        if (!StringUtils.isEmpty(annotation.message())) {
            messages.error(annotation.message());

            requestContextManager.updateMainMessagesGrowl();
        }

        if (annotation.update().length > 0) {
            requestContextManager.addUpdates(Arrays.asList(annotation.update()));
        }

        if (annotation.execute().length > 0) {
            requestContextManager.registerJsFunctions(Arrays.asList(annotation.execute()));
        }
    }
}
