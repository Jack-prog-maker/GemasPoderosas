package com.blackhole.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.blackhole.game.Assets.AssetDescriptors;
import com.blackhole.game.Assets.RegionNames;
import com.blackhole.game.GameBase;
import com.blackhole.game.common.SoundListener;
import com.blackhole.game.game.Abismo;


public class LoadingScreen extends ScreenAdapter {

    // == constants ==
    private static final float PROGRESS_BAR_WIDTH =  2f;
    private static final float PROGRESS_BAR_HEIGHT = 60f;

    // == attributes ==
    private final GameBase game;
    private final AssetManager assetManager;
    private SoundListener listener;

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;
    private SpriteBatch batch;

    private float progress;
    private float waitTime = 0.75f;

    private boolean changeScreen;

    private final float VIRTUAL_WIDTH = 768;
    private final float VIRTUAL_HEIGHT = 1024;

    private float larguraDispositivo;
    private float alturaDispositivo;

    private Texture logo;
    private Texture loading;



    // == constructors ==
    public LoadingScreen(GameBase game) {
        this.game = game;
        assetManager = game.getAssetManager();

    }


    // == public methods ==
    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        renderer = new ShapeRenderer();
        camera.position.set(VIRTUAL_WIDTH/2,VIRTUAL_HEIGHT/2, 0);
        viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

        larguraDispositivo = VIRTUAL_WIDTH;
        alturaDispositivo  = VIRTUAL_HEIGHT;

        assetManager.load(AssetDescriptors.FONT);
        assetManager.load(AssetDescriptors.GAME_PLAY);
        assetManager.load(AssetDescriptors.SKIN);
        assetManager.load(AssetDescriptors.COIN);
        assetManager.load(AssetDescriptors.LOSE);
        assetManager.load(AssetDescriptors.JUMP);

        logo = new Texture("logo.png");
        loading = new Texture("loading.png");





    }

    @Override
    public void render(float delta) {
        update(delta);

        camera.update();

        // Limpar frames anteriores
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.draw(logo,  0, 0,  larguraDispositivo, alturaDispositivo);
        batch.draw(loading,  100, 100);

        batch.end();

        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLACK);

        draw();

        renderer.end();



        if (changeScreen) {
            game.setScreen(new Abismo(game));
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();

    }

    // == private methods ==
    private void update(float delta) {
        progress = assetManager.getProgress();

        if (assetManager.update()) {
            waitTime -= delta;

            if (waitTime <= 0) {
                changeScreen = true;
            }
        }
    }

    private void draw() {

        renderer.rect(100, 100,
                progress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT);
    }



}
