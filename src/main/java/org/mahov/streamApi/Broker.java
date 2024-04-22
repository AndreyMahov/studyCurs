package org.mahov.streamApi;

public class Broker {
    private String name;
    private BrokerageFirm brokerageFirm;

    public Broker(String name, BrokerageFirm brokerageFirm) {
        this.name = name;
        this.brokerageFirm = brokerageFirm;
    }

    public Broker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrokerageFirm getBrokerageFirm() {
        return brokerageFirm;
    }

    public void setBrokerageFirm(BrokerageFirm brokerageFirm) {
        this.brokerageFirm = brokerageFirm;
    }
}
