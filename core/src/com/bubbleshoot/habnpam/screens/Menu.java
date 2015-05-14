package com.bubbleshoot.habnpam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bubbleshoot.habnpam.Shooter;

public class Menu extends BaseScreen {



    public Menu(Shooter s){
        super(s);

        init();

    }

    /** private void init();
     * This function creates the buttons that make up the menu,
     * and attaches a ClickListener to each one.
     *
     * WHY CREATE THIS FUNCTION? WHY NOT JUST USE SHOW() INSTEAD?
     * - because show() is called every time the screen is accessed.
     * - So each time the menu screen is accessed, 4 more buttons are created.
     * - init() is only called from the constructor. So it is only called once.
     *
     * WHY NOT PUT IT IN THE CONSTRUCTOR?
     * - because then multiple methods will have access to the same local variable. clicklistener() and super()
     * - and to fix that, The Shooter pointer 's' would have to be declared "final".
     * - I don't want to declare that as "final".
    */
     private void init(){

        //Declaring the buttons.
        //The options are: Play, Settings, Instructions, Profile.
        TextButton play = new TextButton("Play", s.assets.buttonStyle);
        TextButton options = new TextButton("Settings", s.assets.buttonStyle);
        TextButton instructions = new TextButton("Instructions", s.assets.buttonStyle);
        TextButton profile = new TextButton("Profile", s.assets.buttonStyle);

        //Give each button a ClickListener.
        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                s.setScreen(s.worldMap);
            }
        });

        options.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                s.setScreen(s.setting);
            }
        });

        instructions.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                s.setScreen(s.instruction);

            }
        });
        profile.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                s.setScreen(s.profile);
            }
        });

        //Adding the buttons to the masterTable(declared in BaseScreen)
        masterTable.add(play).pad(10).row();
        masterTable.add(options).pad(10).row();
        masterTable.add(instructions).pad(10).row();
        masterTable.add(profile).pad(10).row();

        masterTable.setPosition(s.assets.w / 2, s.assets.h / 2);
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(this.stage);

    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    @Override
    public void dispose(){

    }

}
