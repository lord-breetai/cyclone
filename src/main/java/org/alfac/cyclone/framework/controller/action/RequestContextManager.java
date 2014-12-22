package org.alfac.cyclone.framework.controller.action;

import org.primefaces.context.RequestContext;
import org.primefaces.util.ComponentUtils;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan
 */
@Named
public class RequestContextManager implements Serializable {

    private static final String MESSAGE_COMPONENT_ID = "mainMessagesGrowlId";

    public void updateMainMessagesGrowl() {
        RequestContext instance = RequestContext.getCurrentInstance();
        instance.update(MESSAGE_COMPONENT_ID);
    }

    public void addUpdates(List<String> elements) {
        List<String> clientIds = new ArrayList<>();

        for (String element : elements) {
            clientIds.add(ComponentUtils.findComponentClientId(element));
        }

        RequestContext instance = RequestContext.getCurrentInstance();
        for (String clientId : clientIds) {
            instance.update(clientId);
        }
    }

    public void registerJsFunctions(List<String> functions) {
        RequestContext instance = RequestContext.getCurrentInstance();

        for (String jsFunction : functions) {
            instance.execute(jsFunction);
        }
    }
}
