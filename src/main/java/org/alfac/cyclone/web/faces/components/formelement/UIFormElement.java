package org.alfac.cyclone.web.faces.components.formelement;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

/**
 * @author Ivan
 */
@ResourceDependencies({
        @ResourceDependency(library = "css", name = "formElement.css")
})
@FacesComponent(value = UIFormElement.COMPONENT_TYPE)
public class UIFormElement extends UINamingContainer {

    public static final String COMPONENT_TYPE = "cyclone.faces.FormElement";

    private enum PropertyKeys {
        labelClass,
        contentClass,
        required
    }

    private enum CssStyles {
        formElementLabel,
        formElementContent
    }

    public void setRequired(boolean required) {
        getStateHelper().put(PropertyKeys.required, required);
    }

    public boolean isRequired() {
        return (Boolean) getStateHelper().eval(PropertyKeys.required, Boolean.FALSE);
    }

    public String getContentClass() {
        String result = CssStyles.formElementContent.name();

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
        String result = CssStyles.formElementLabel.name();

        String labelClass = (String) getStateHelper().eval(PropertyKeys.labelClass, "");
        if (!"".equals(labelClass)) {
            result = result + " " + labelClass;
        }

        return result;
    }

    public void setLabelClass(String labelClass) {
        getStateHelper().put(PropertyKeys.labelClass, labelClass);
    }
}
