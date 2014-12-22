package org.alfac.cyclone.web.faces.utils;

import org.apache.deltaspike.core.util.PropertyFileUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Ivan
 */
@Named("jsfMessages")
public class Messages implements Serializable {

    public void info(String messageKey) {
        addFacesMessage(null, FacesMessage.SEVERITY_INFO, messageKey);
    }

    public void info(String messageKey, Object... params) {
        addFacesMessage(null, FacesMessage.SEVERITY_INFO, messageKey, params);
    }

    public void error(String messageKey) {
        addFacesMessage(null, FacesMessage.SEVERITY_ERROR, messageKey);
    }

    public void error(String messageKey, Object... params) {
        addFacesMessage(null, FacesMessage.SEVERITY_ERROR, messageKey, params);
    }

    private void addFacesMessage(String id, FacesMessage.Severity severity, String messageKey, Object... params) {
        FacesContext facesContext = JSFUtil.getFacesContext();

        facesContext.addMessage(id, createFacesMessage(severity, messageKey, params));
    }

    private FacesMessage createFacesMessage(FacesMessage.Severity severity, String messageKey, Object... params) {
        return new FacesMessage(severity, getMessage(messageKey, params), null);
    }

    public String getMessage(
            String key,
            Object... parameters) {
        String message = "???" + key + "???";

        FacesContext facesContext = JSFUtil.getFacesContext();
        ResourceBundle resourceBundle = PropertyFileUtils.getResourceBundle(facesContext.getApplication().getMessageBundle(), getLocale());

        try {
            message = resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            return message;
        }
        if (parameters != null) {
            StringBuffer stringBuffer = new StringBuffer();
            MessageFormat messageFormat = new MessageFormat(message,
                    getLocale());
            message = messageFormat.format(parameters, stringBuffer,
                    null).toString();
        }
        return message;
    }

    private Locale getLocale() {
        FacesContext facesContext = JSFUtil.getFacesContext();
        return facesContext.getApplication().getViewHandler().calculateLocale(facesContext);
    }
}
