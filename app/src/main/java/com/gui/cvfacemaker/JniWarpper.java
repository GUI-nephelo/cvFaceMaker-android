package com.gui.cvfacemaker;


public class JniWarpper {
    public static void init() {
        System.loadLibrary("native-lib");
    }

    public static native String stringFromJNI();
}
