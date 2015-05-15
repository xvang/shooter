package com.bubbleshoot.habnpam.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.bubbleshoot.habnpam.Shooter;

/**
 * BaseScreen has elements that every Screen should have.
 * Stage, skin, table, etc.
 * */
public abstract class BaseScreen extends ScreenAdapter {

    Stage stage;
    SpriteBatch batch;
    Table masterTable;
    Shooter s;
    Skin skin; //pointer to the Skin created in Asset

    TextButton menuButton;


    public BaseScreen(Shooter shooter){
        s = shooter;

        stage = new Stage(new StretchViewport(s.assets.w,s.assets.h));
        batch = new SpriteBatch();
        masterTable = new Table();
        skin = s.assets.uiSkin;

        //A ClickListener cannot be added to menuButton here.
        menuButton = new TextButton("Menu", s.assets.buttonStyle);

        //menuButton.setSize(100,200);
        menuButton.setPosition(20f, 20f);

        //mute/un-mute buttons.
        //ImageButton can take in a Drawable as a parameter.
        //SpriteDrawable is drawable version of a Sprite...?
        //Sprite requires a Texture.
        final ImageButton sound = new ImageButton(new SpriteDrawable(new Sprite(new Texture("transparentDark11.png"))));
        final ImageButton sound_mute = new ImageButton(new SpriteDrawable(new Sprite(new Texture("transparentDark13.png"))));

        //Initially, there will be sound so we see the 'sound' button.
        //I know the default visibility is true,
        //but this way is just easier to look at.
        sound.setVisible(true);
        sound_mute.setVisible(false);

        sound.setPosition(10, s.assets.h - sound.getHeight() - 10);
        sound_mute.setPosition(10, s.assets.h - sound_mute.getHeight() - 10);



        //TODO: Implement the sound.
        sound.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                sound.setVisible(false);
                sound_mute.setVisible(true);
            }
        });

        sound_mute.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                sound_mute.setVisible(false);
                sound.setVisible(true);
            }
        });

        stage.addActor(menuButton);
        stage.addActor(masterTable);
        stage.addActor(sound);
        stage.addActor(sound_mute);



    }

    @Override
    public void resize(int x, int y){
        stage.getViewport().update(x, y, false);
    }

}
