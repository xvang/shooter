package com.bubbleshoot.habnpam;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.bubbleshoot.habnpam.screens.Instruction;
import com.bubbleshoot.habnpam.screens.Menu;
import com.bubbleshoot.habnpam.screens.Setting;
import com.bubbleshoot.habnpam.screens.Profile;
import com.bubbleshoot.habnpam.screens.WorldMap;

public class Shooter extends Game {


	public Instruction instruction;
	public Menu menu;
	public Setting setting;
	public Profile profile;
	public WorldMap worldMap;
	public Asset assets;

	@Override
	public void create () {

		assets = new Asset();

		instruction = new Instruction(this);
		menu = new Menu(this);
		setting = new Setting(this);
		profile = new Profile(this);
		worldMap = new WorldMap(this);

		this.setScreen(menu);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}

	@Override
	public void dispose(){
		assets.dispose();
	}
}
