package org.mahov.streamApi;

public enum BrokerageFirm {
    GOLDEN_SOCK("golden sock"),
    WELL_FED_GOOSE("well-fed goose"),
    lION_GATE("lion gate");

    private final String value;

    BrokerageFirm(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
