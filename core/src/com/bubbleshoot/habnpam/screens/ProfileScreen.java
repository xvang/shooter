package com.bubbleshoot.habnpam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bubbleshoot.habnpam.Shooter;

public class ProfileScreen extends BaseScreen {


    public ProfileScreen(Shooter s){
        super(s);
        init();
    }




    private void init(){
        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                System.out.println("PROFILESCREEN");
                s.setScreen(s.menu);
            }
        });

        Label.LabelStyle labelStyle = new Label.LabelStyle();

        labelStyle.font = s.assets.font;

        String nameText = "Name: " + s.profile.getName();
        String scoreText = "Score: " + String.valueOf(s.profile.getScore());
        Label name = new Label(nameText, labelStyle);
        Label score = new Label(scoreText, labelStyle);

        masterTable.add(name).row();
        masterTable.add(score);
        masterTable.setPosition(s.assets.w/2, s.assets.h/2);
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
