package com.bubbleshoot.habnpam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bubbleshoot.habnpam.Level;
import com.bubbleshoot.habnpam.Shooter;

public class WorldMap extends BaseScreen {


    public WorldMap(Shooter s){
        super(s);
        init();
    }
    private void init(){
        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                s.setScreen(s.menu);
            }
        });



        //for-loop adds in all the buttons that point to the levels.
        for(int x = 0; x < s.profile.numberOfLevels; x++){

            TextButton a;

            //if level is unlocked, button is a lighter color.
            //else, button is darker colored.
            if (s.profile.levels[x])
                a = new TextButton(String.valueOf(x+1), s.assets.buttonUnlocked);
            else
                a = new TextButton(String.valueOf(x+1), s.assets.buttonLocked);

            //add button to table.
            //we want 4 buttons per row.
            if((x+1) % 5 == 0 && x > 0)
                masterTable.add(a).pad(20).row();
            else
                masterTable.add(a).pad(20);

            //Add Listeners to the buttons.
            //The listeners change the screen to the gameplay screen.
            final int xx = x;
            a.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent e, float x, float y){
                    final Level level = new Level(xx+1);
                    s.setScreen(new GameScreen(level, s));
                }
            });
        }




        masterTable.setPosition(s.assets.w/2, s.assets.h/2);
        stage.addActor(masterTable);


    }
    @Override
    public void show(){

        Gdx.input.setInputProcessor(this.stage);
    }

    @Override
    public void render(float delta){

        batch.begin();
        background1.draw(batch);
        background2.draw(batch);
        batch.end();

        stage.draw();

        scrollBackground();

    }

    @Override
    public void dispose(){

    }
}
