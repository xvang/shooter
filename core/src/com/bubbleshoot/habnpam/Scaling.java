package com.bubbleshoot.habnpam;

public class Scaling {

    public static final int TARGET_WIDTH = 900;
    public static final int TARGET_HEIGHT = 600;
    public static final float PIXELS_PER_METER = 90;
    public static final int DEFAULT_TITLE_WIDTH = 64;

    public static float pixelsToMeters(float pixels){
        return pixels/PIXELS_PER_METER;
    }

    public static float metersToPixels(float meters){
        return meters * PIXELS_PER_METER;
    }

    public static float getInitialWidth(){
        return pixelsToMeters(TARGET_WIDTH);
    }

    public static float getInitialHeight(){
        return pixelsToMeters(TARGET_HEIGHT);
    }
}
