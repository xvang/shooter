package com.bubbleshoot.habnpam.tests;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.bubbleshoot.habnpam.Scaling;

public class Box2dTest extends ScreenAdapter implements InputProcessor {

    World world = new World(new Vector2(0, -100), true);
    Box2DDebugRenderer debugRenderer;
    OrthographicCamera camera;
    static final float BOX_STEP=1/60f;
    static final int BOX_VELOCITY_ITERATIONS=6;
    static final int BOX_POSITION_ITERATIONS=2;
    static final float WORLD_TO_BOX=0.01f;
    static final float BOX_WORLD_TO=100f;

    Body body;


    SpriteBatch batch;
    Sprite background;
    Scaling scale;
    public Box2dTest(){

        scale = new Scaling();
        batch = new SpriteBatch();
        background = new Sprite(new Texture("space-background.png"));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(0,0);
        //http://joelotter.com/pixels-are-evil/
        camera = new OrthographicCamera();
        camera.viewportHeight = 320;
        camera.viewportWidth = 480;
        camera.position.set(camera.viewportWidth * .5f, camera.viewportHeight * .5f, 0f);
        camera.update();
        //Ground body
        BodyDef groundBodyDef =new BodyDef();
        groundBodyDef.position.set(new Vector2(0, 10));
        Body groundBody = world.createBody(groundBodyDef);
        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox((camera.viewportWidth) * 2, 10.0f);
        groundBody.createFixture(groundBox, 0.0f);

        //Dynamic Body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(camera.viewportWidth / 2, camera.viewportHeight*3 / 4);
        body = world.createBody(bodyDef);
        CircleShape dynamicCircle = new CircleShape();
        dynamicCircle.setRadius(5f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = dynamicCircle;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.0f;
        fixtureDef.restitution = 2;
        body.createFixture(fixtureDef);


        debugRenderer = new Box2DDebugRenderer();

        dynamicCircle.dispose();
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        batch.end();
        debugRenderer.render(world, camera.combined);
        world.step(BOX_STEP, BOX_VELOCITY_ITERATIONS, BOX_POSITION_ITERATIONS);
    }



    @Override
    public void dispose(){

    }

    @Override
    public void resize(int x, int y){
        if (y < x){
        }
    }

    @Override
    public void hide(){

    }
    @Override
    public void pause(){}

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {

        Array<Body> bodies = new Array<Body>();

        world.getBodies(bodies);

        for(Body body: bodies) {
            if (body.getType().equals(BodyDef.BodyType.DynamicBody)) {
                System.out.println(body.getPosition());
                System.out.println();
                System.out.println("-----");
            }

        }
        /*int height = Gdx.graphics.getHeight();
        System.out.println("viewportwidth: " + String.valueOf(camera.viewportWidth));
        System.out.println("x: " + String.valueOf(x));
        System.out.println("body = " + String.valueOf(body.getLocalVector(new Vector2())));
        //Dynamic Body

        //Bodydef defines the shape and type.
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x/2, y / 2);

        //body is just a pointer. world.createbody() can be by itself.
        body = world.createBody(bodyDef);
        CircleShape dynamicCircle = new CircleShape();
        dynamicCircle.setRadius(4f);

        //FixtureDef defines the property.
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = dynamicCircle;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 1;

        //Body is the actual object.
        body.createFixture(fixtureDef);

        dynamicCircle.dispose();*/
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer) {

        /*int height = Gdx.graphics.getHeight();
        System.out.println("Creating new Circles.");
        //Dynamic Body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, camera.viewportHeight / 2);
        body = world.createBody(bodyDef);
        CircleShape dynamicCircle = new CircleShape();
        dynamicCircle.setRadius(4f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = dynamicCircle;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 1;
        body.createFixture(fixtureDef);

        dynamicCircle.dispose();*/

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
