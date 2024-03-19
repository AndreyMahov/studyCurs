package org.mahov.interfaces.model;

import org.mahov.interfaces.BeWild;
import org.mahov.interfaces.MakeSound;
import org.mahov.interfaces.TakeBreak;

public class Wolf extends Animal implements MakeSound, TakeBreak, BeWild {
    public Wolf(int legsCount) {
        super(legsCount);
    }

    @Override
    public int getLegsCount() {
        return super.getLegsCount();
    }

    @Override
    public void setLegsCount(int legsCount) {
        super.setLegsCount(legsCount);
    }

    @Override
    public void sound() {
        System.out.println("woff woof");
    }

    @Override
    public void wildModeOn() {
        System.out.println("start be wild");
    }
}
