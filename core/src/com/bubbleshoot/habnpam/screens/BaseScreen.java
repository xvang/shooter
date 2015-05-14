package com.bubbleshoot.habnpam.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.bubbleshoot.habnpam.Shooter;

public abstract class BaseScreen extends ScreenAdapter {

    Stage stage;
    Table masterTable;
    Shooter s;
    Skin skin; //pointer to the Skin created in Asset

    TextButton menuButton;


    public BaseScreen(Shooter shooter){
        s = shooter;

        stage = new Stage();
        masterTable = new Table();
        skin = s.assets.uiSkin;

        menuButton = new TextButton("Menu", s.assets.buttonStyle);

        //menuButton.setSize(100,200);
        menuButton.setPosition(20f, 20f);


        stage.addActor(menuButton);
        stage.addActor(masterTable);


    }


}
