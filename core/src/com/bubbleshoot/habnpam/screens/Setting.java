package com.bubbleshoot.habnpam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bubbleshoot.habnpam.Shooter;

public class Setting extends BaseScreen {

    public Setting(Shooter s){
        super(s);

        init();
    }


    private void init(){
        menuButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                System.out.println("SETTING");
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
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();

    }

    @Override
    public void dispose(){

    }

}
