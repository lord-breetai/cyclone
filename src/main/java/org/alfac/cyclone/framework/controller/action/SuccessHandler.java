package org.alfac.cyclone.framework.controller.action;

import org.alfac.cyclone.framework.controller.action.annotation.Success;
import org.alfac.cyclone.web.faces.utils.Messages;
import org.apache.deltaspike.core.util.StringUtils;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Ivan
 */

@Named
public class SuccessHandler implements Serializable {

    @Inject
    private RequestContextManager requestContextManager;

    @Inject
    private Messages messages;

    public void handle(Success annotation) {
        if (!StringUtils.isEmpty(annotation.message())) {
            messages.info(annotation.message());

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
