package com.bubbleshoot.habnpam;


import com.badlogic.gdx.utils.Array;
import com.bubbleshoot.habnpam.bullets.Bullet;
import com.bubbleshoot.habnpam.enemies.Enemy;

/**
 * This class contains information about the level,
 * such as what kind of enemies to spawn,
 * what kind of bullets can be shot,
 * how many enemies should spawn,
 * etc.
 *
 * */
public class Level {

    public int enemyCount;
    public Array<Enemy> enemyArray;
    public Array<Bullet> bulletArray;


    public Level(int levelNumber){
        enemyCount = levelNumber;

    }



}
