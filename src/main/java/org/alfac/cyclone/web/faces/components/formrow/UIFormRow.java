package org.alfac.cyclone.web.faces.components.formrow;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

/**
 * @author Ivan
 */
@ResourceDependencies({
        @ResourceDependency(library = "js", name = "cyclone.js"),
        @ResourceDependency(library = "css", name = "formRow.css"),
        @ResourceDependency(library = "js", name = "formRow.js")
})
@FacesComponent(value = UIFormRow.COMPONENT_TYPE)
public class UIFormRow extends UINamingContainer {

    public static final String COMPONENT_TYPE = "cyclone.faces.FormRow";

    public void setRequired(boolean required) {
        getStateHelper().put(PropertyKeys.required, required);
    }

    public boolean isRequired() {
        return (Boolean) getStateHelper().eval(PropertyKeys.required, Boolean.FALSE);
    }

    public String getContentClass() {
        String result = CssStyles.formRowContent.name();

        String contentClass = (String) getStateHelper().eval(PropertyKeys.contentClass, "");
        if (!"".equals(contentClass)) {
            result = result + " " + contentClass;
        }

        return result;
    }

    public void setContentClass(String contentClass) {
        getStateHelper().put(PropertyKeys.contentClass, contentClass);
    }

    public String getLabelClass() {
        String labelClass = (String) getStateHelper().eval(PropertyKeys.labelClass, "");
        if ("".equals(labelClass)) {
            labelClass = CssStyles.formRowLabelWidth.name();
        }

        return CssStyles.formRowLabel.name() + " " + labelClass;
    }

    public void setLabelClass(String labelClass) {
        getStateHelper().put(PropertyKeys.labelClass, labelClass);
    }

    private enum PropertyKeys {
        labelClass,
        contentClass,
        required
    }

    private enum CssStyles {
        formRowLabel,
        formRowContent,
        formRowLabelWidth
    }
}
