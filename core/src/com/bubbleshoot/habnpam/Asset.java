package com.bubbleshoot.habnpam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Asset {

    public AssetManager manager;
    public BitmapFont font;
    public Skin uiSkin;
    public TextButton.TextButtonStyle buttonStyle, buttonLocked, buttonUnlocked;
    public final float w, h;

    private String ttfFile = "soupofjustice.ttf";
    public Sprite menuBackground1, menuBackground2;


    public ImageButton sound, sound_mute;

    public ParticleEffectPool effectPool;
    private ParticleEffect singleParticle;
    public Asset(){
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        manager = new AssetManager();

        //There are 2 backgrounds because they will
        //be used for inifite scrolling.
        menuBackground1 = new Sprite(new Texture("bg_1_1.png"));
        menuBackground1.setSize(w,h);

        menuBackground2 = new Sprite(new Texture("bg_1_1.png"));
        menuBackground2.setSize(w,h);
        menuBackground2.setPosition(w,0);


        FileHandleResolver resolver = new InternalFileHandleResolver();

        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));


        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter =
                new FreetypeFontLoader.FreeTypeFontLoaderParameter();

        parameter.fontFileName = ttfFile;
        parameter.fontParameters.size = 24;
        parameter.fontParameters.color = Color.WHITE;
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

        buttonLocked = new TextButton.TextButtonStyle();
        buttonLocked.font = font;
        buttonLocked.fontColor = Color.BLACK;
        buttonLocked.up = uiSkin.getDrawable("buttonSquare_blue");
        buttonLocked.down = uiSkin.getDrawable("buttonSquare_brown");

        buttonUnlocked = new TextButton.TextButtonStyle();
        buttonUnlocked.font = font;
        buttonUnlocked.fontColor = Color.BLACK;
        buttonUnlocked.up = uiSkin.getDrawable("buttonSquare_grey");
        buttonUnlocked.down = uiSkin.getDrawable("buttonSquare_brown");





        //creating the particles.
        singleParticle = new ParticleEffect();
        singleParticle.load(Gdx.files.internal("particles/p1.p"),
                Gdx.files.internal("particles/"));

        singleParticle.start();
        singleParticle.setEmittersCleanUpBlendFunction(false);
        effectPool = new ParticleEffectPool(singleParticle, 0, 1000);


    }

    public void dispose(){
        manager.unload(ttfFile);
        manager.unload("adventure.pack");
    }
}
