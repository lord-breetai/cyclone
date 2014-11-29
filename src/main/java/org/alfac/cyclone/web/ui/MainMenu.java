package org.alfac.cyclone.web.ui;

import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.LinkedList;

/**
 * @author Ivan
 */
@RequestScoped
@Named
public class MainMenu {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(MainMenu.class);

    private enum MenuItem {
        STUDENT("/student/home.xhtml"),
        ADMINISTRATION("/admin/administrationMenu.xhtml");

        private String viewId;

        MenuItem(String viewId) {
            this.viewId = viewId;
        }

        public String getViewId() {
            return viewId;
        }
    }

    public Integer getActiveIndex() {
        LinkedList<String> viewIds = new LinkedList<>();

        for (MenuItem menuItem : MenuItem.values()) {
            viewIds.add(menuItem.getViewId());
        }

        Integer index = viewIds.indexOf(loadSelectedViewId());
        if (-1 == index) {
            index = 0;
        }

        return index;
    }

    private String loadSelectedViewId() {
        return FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }
}
