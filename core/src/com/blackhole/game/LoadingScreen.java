package com.blackhole.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.blackhole.game.common.SoundListener;


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
    private float waitTime = 0.95f;

    private boolean changeScreen;

    private final float VIRTUAL_WIDTH = 768;
    private final float VIRTUAL_HEIGHT = 1024;

    private float larguraDispositivo;
    private float alturaDispositivo;

    private Texture intro;



    private Animation<TextureRegion> fundo;
    private float elapsed;


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
        camera.position.set(VIRTUAL_WIDTH/2,VIRTUAL_HEIGHT/2, 0);
        viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

        larguraDispositivo = VIRTUAL_WIDTH;
        alturaDispositivo  = VIRTUAL_HEIGHT;

        intro = new Texture("logo.png");
        fundo = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("loading.gif").read());

        assetManager.load(AssetDescriptors.FONT);
        assetManager.load(AssetDescriptors.SKIN);
        assetManager.load(AssetDescriptors.COIN);
        assetManager.load(AssetDescriptors.LOSE);








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

        batch.draw(intro,  larguraDispositivo / 2 - 400 / 2, alturaDispositivo / 2, 400, 250);
        batch.draw(fundo.getKeyFrame(elapsed),  larguraDispositivo / 2 - 400 / 2, alturaDispositivo / 2, 400, 250);

        batch.end();


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
            elapsed += delta;

            if (waitTime <= 0) {
                changeScreen = true;
            }
        }
    }


}
