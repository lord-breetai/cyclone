package org.alfac.cyclone.web.faces.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Ivan
 */
public final class JSFUtil {

    private JSFUtil() {
    }

    public static String getRequestParamValue(String paramName) {
        FacesContext context = getFacesContext();

        return ((HttpServletRequest) context.getExternalContext().getRequest()).getParameter(paramName);
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
