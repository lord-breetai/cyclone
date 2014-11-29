package org.alfac.cyclone.model;

/**
 * @author Ivan
 */
public enum LeadTimeType {
    HOUR("LeadTimeType.HOUR"),
    DAY("LeadTimeType.DAY"),
    MONTH("LeadTimeType.MONTH"),
    YEAR("LeadTimeType.YEAR");

    private String resourceKey;

    LeadTimeType(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public String getResourceKey() {
        return resourceKey;
    }
}
