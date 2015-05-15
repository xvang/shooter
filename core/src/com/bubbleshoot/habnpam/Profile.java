package com.bubbleshoot.habnpam;

/**
 * This class contains information about the player.
 *
 * */
public class Profile {

    private String NAME;
    private float score;

    public Profile(){
        NAME = "Username";
        score = 123456;

    }
    public void setName(String n){NAME = n;}
    public void setScore(float s){score += s;}

    public String getName(){return NAME;}
    public float getScore(){return  score;}


}
