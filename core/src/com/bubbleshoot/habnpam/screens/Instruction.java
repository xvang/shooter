package com.bubbleshoot.habnpam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bubbleshoot.habnpam.Shooter;

public class Instruction extends BaseScreen {

    public Instruction(Shooter s){
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
