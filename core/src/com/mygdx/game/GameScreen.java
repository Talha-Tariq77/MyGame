package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    final MyGdxGame game;
    Texture img;

    OrthographicCamera camera;

    int img_x;
    int img_y;
    World world;
    Box2DDebugRenderer debugRenderer;


    public GameScreen(final MyGdxGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);

        img = new Texture(Gdx.files.internal("badlogic.jpg"));
        float img_x = 0;
        float img_y = 0;

        Box2D.init();
        World world = new World(new Vector2(0, -10), true);
        Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();


    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(img, img_x, img_y);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            img_x += 200 * Gdx.graphics.getDeltaTime();
            System.out.println(img_x);
        }

        world.step(1/60f, 6, 2);
    }
    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        img.dispose();
    }
}
