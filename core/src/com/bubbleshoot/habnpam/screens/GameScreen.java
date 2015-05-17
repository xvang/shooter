package com.bubbleshoot.habnpam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.bubbleshoot.habnpam.Level;
import com.bubbleshoot.habnpam.Shooter;

public class GameScreen extends ScreenAdapter implements InputProcessor {


    Stage stage;
    SpriteBatch batch;
    Shooter s;
    Array<ParticleEffectPool.PooledEffect> activeParticles;
    public GameScreen(Level levelInfo, Shooter s){

        stage = new Stage();
        this.s = s;
        activeParticles = new Array<ParticleEffectPool.PooledEffect>();
        batch = new SpriteBatch();

    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        for(int x = 0; x < activeParticles.size; x++){
            ParticleEffectPool.PooledEffect e = activeParticles.get(x);
            e.draw(batch, delta);

            if(e.isComplete()){
                activeParticles.removeIndex(x);
                e.free();
            }
        }

        batch.end();

    }






    @Override
    public void resize(int x, int y){
    }

    @Override
    public void hide(){
    }
    @Override
    public void pause(){}

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {return false;}

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        //Create particles at position where user touched.
        ParticleEffectPool.PooledEffect effect = s.assets.effectPool.obtain();
        effect.setPosition(screenX, s.assets.h - screenY);
        activeParticles.add(effect);

        return false;
    }


    @Override
    public boolean mouseMoved(int screenX, int screenY) {return false;}

    @Override
    public boolean scrolled(int amount) {return false;}

    @Override
    public boolean keyDown(int keycode) {return false;}

    @Override
    public boolean keyUp(int keycode) {return false;}

    @Override
    public boolean keyTyped(char character) {return false;}


    @Override
    public void dispose(){
    }


}
