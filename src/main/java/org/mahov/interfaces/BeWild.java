package org.mahov.interfaces;

public interface BeWild {
     final static String line = "static";

    void wildModeOn();

    default void defaultWIld(){
        System.out.println("defaul");
    }
}
