package com.bubbleshoot.habnpam;

/**
 * This class contains information about the player.
 *
 * */
public class Profile {

    private String NAME;
    private float score;
    public final int numberOfLevels = 20;

    public boolean[] levels = new boolean[numberOfLevels];
    public Profile(){
        NAME = "Username";
        score = 123456;

        levels[0] = true;

        for (int x = 1; x < levels.length; x++)
            levels[x] = false;
    }
    public void setName(String n){NAME = n;}
    public void setScore(float s){score += s;}

    public String getName(){return NAME;}
    public float getScore(){return  score;}


}
