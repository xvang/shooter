package com.bubbleshoot.habnpam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Asset {

    public AssetManager manager;
    public BitmapFont font;
    public Skin uiSkin;
    public TextButton.TextButtonStyle buttonStyle;
    public final float w, h;


    public Asset(){
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        manager = new AssetManager();
        FileHandleResolver resolver = new InternalFileHandleResolver();

        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter =
                new FreetypeFontLoader.FreeTypeFontLoaderParameter();

        parameter.fontFileName = "kenvector_future_thin.ttf";
        parameter.fontParameters.size = 20;
        manager.load("kenvector_future_thin.ttf", BitmapFont.class, parameter);


        //Load in the assets files.
        manager.load("adventure.pack", TextureAtlas.class);
        manager.finishLoading();

        //getting the files.
        TextureAtlas textureAtlas = manager.get("adventure.pack", TextureAtlas.class);
        font = manager.get("kenvector_future_thin.ttf", BitmapFont.class);

        //Creating the skin.
        uiSkin = new Skin();
        uiSkin.addRegions(textureAtlas);

        //Creating a style for the buttons.
        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;
        buttonStyle.fontColor = Color.BLACK;
        buttonStyle.up = uiSkin.getDrawable("buttonLong_grey");
        buttonStyle.down = uiSkin.getDrawable("buttonLong_beige");
    }

    public void dispose(){
        manager.unload("kenvector_future_thin.ttf");
        manager.unload("adventure.pack");
    }
}
