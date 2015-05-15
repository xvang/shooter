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
                System.out.println("Instructions");
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
        s.assets.menuBackground.draw(batch);
        batch.end();

        stage.draw();

    }

    @Override
    public void dispose(){

    }
}
