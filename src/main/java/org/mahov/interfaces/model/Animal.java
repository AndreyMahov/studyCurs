package org.mahov.interfaces.model;

public abstract class Animal {
    private int LegsCount;

    public Animal(int legsCount) {
        LegsCount = legsCount;
    }

    public int getLegsCount() {
        return LegsCount;
    }

    public void setLegsCount(int legsCount) {
        LegsCount = legsCount;
    }
}
