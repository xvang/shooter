package com.bubbleshoot.habnpam.tests;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import aurelienribon.bodyeditor.BodyEditorLoader;


public class Box2dTest extends ScreenAdapter implements InputProcessor {


    private World world;
    Box2DDebugRenderer debugRenderer;
    OrthographicCamera camera;
    Body bottleModel;
    Vector2 bottleModelOrigin;
    private Sprite bottleSprite;
    private Texture bottleTexture;

    private static final float BOTTLE_WIDTH = 8;

    public Box2dTest(){
        world = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera();

        BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal("physics/test.json"));

        BodyDef bd = new BodyDef();
        bd.position.set(0,0);
        bd.type = BodyDef.BodyType.DynamicBody;

        FixtureDef fd = new FixtureDef();
        fd.density = 1;
        fd.friction = 0.5f;
        fd.restitution = 0.3f;

        bottleModel = world.createBody(bd);

        loader.attachFixture(bottleModel, "test01", fd, BOTTLE_WIDTH);

        bottleModelOrigin = new Vector2();
        bottleModelOrigin = loader.getOrigin("test01", BOTTLE_WIDTH).cpy();


        bottleTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
        bottleTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        bottleSprite = new Sprite(bottleTexture);
        bottleSprite.setSize(BOTTLE_WIDTH, BOTTLE_WIDTH*bottleSprite.getHeight()/bottleSprite.getWidth());



    }

    @Override
    public void show(){

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Vector2 bottlePos = bottleModel.getPosition().sub(bottleModelOrigin);
        bottleSprite.setPosition(bottlePos.x, bottlePos.y);
        bottleSprite.setOrigin(bottleModelOrigin.x, bottleModelOrigin.y);
        bottleSprite.setRotation(bottleModel.getAngle() * MathUtils.radiansToDegrees);

        debugRenderer.render(world, camera.combined);
        world.step(1/60f, 6, 2);

    }



    @Override
    public void dispose(){

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
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {return false;}

    @Override
    public boolean scrolled(int amount) {
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return true;
    }

    @Override
    public boolean keyTyped(char character) {return false;}


}
