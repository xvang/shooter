package com.bubbleshoot.habnpam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Asset {

    public AssetManager manager;
    public BitmapFont font;
    public Skin uiSkin;
    public TextButton.TextButtonStyle buttonStyle;
    public final float w, h;

    private String ttfFile = "soupofjustice.ttf";
    public Sprite menuBackground;

    public ImageButton sound, sound_mute;
    public Asset(){
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        manager = new AssetManager();
        menuBackground = new Sprite(new Texture("space-background.png"));
        menuBackground.setSize(w,h);



        FileHandleResolver resolver = new InternalFileHandleResolver();

        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));


        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter =
                new FreetypeFontLoader.FreeTypeFontLoaderParameter();

        parameter.fontFileName = ttfFile;
        parameter.fontParameters.size = 22;
        parameter.fontParameters.color = Color.BLUE;
        manager.load(ttfFile, BitmapFont.class, parameter);


        //Load in the assets files.
        manager.load("adventure.pack", TextureAtlas.class);

        manager.finishLoading();

        //getting the files.
        TextureAtlas textureAtlas = manager.get("adventure.pack", TextureAtlas.class);
        font = manager.get(ttfFile, BitmapFont.class);


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
        manager.unload(ttfFile);
        manager.unload("adventure.pack");
    }
}
