package org.alfac.cyclone.web.ui;

import org.alfac.cyclone.web.faces.utils.JSFUtil;
import org.apache.log4j.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Ivan
 */
@Named
@ViewScoped
public class AdministrationMenu implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(AdministrationMenu.class);

    private String viewIdCode;

    private enum MenuItem {
        HOME("/admin/home.xhtml"),
        COUNTRIES("/admin/countries.xhtml"),
        DEGREES("/admin/degrees.xhtml");

        private String viewId;

        MenuItem(String viewId) {
            this.viewId = viewId;
        }

        public String getViewId() {
            return viewId;
        }
    }

    public void loadContent() {
        viewIdCode = JSFUtil.getRequestParamValue("VIEW_ID_CODE");
    }

    public String goToView() {
        if (null == viewIdCode || "".equals(viewIdCode.trim())) {
            return MenuItem.HOME.getViewId();
        }

        MenuItem item = MenuItem.valueOf(viewIdCode);
        return item.getViewId();
    }
}
