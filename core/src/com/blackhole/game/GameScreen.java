package com.blackhole.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.blackhole.game.GameBase;
import com.blackhole.game.common.SoundListener;



public class GameScreen extends ScreenAdapter {

    // == attributes ==
    private final GameBase game;
    private final AssetManager assetManager;
    private final SoundListener listener;

    private Abismo abismo;

    private Sound coinSound;
    private Sound loseSound;

    // == constructors ==
    public GameScreen(final GameBase game) {
        this.game = game;
        assetManager = game.getAssetManager();

        listener = new SoundListener() {
            @Override
            public void hitCoin() {
                coinSound.play();
            }

            @Override
            public void lose() {
                loseSound.play();
                game.getAdController().showInterstitial();
            }
        };
    }

    // == public methods ==
    @Override
    public void show() {
        coinSound = assetManager.get(AssetDescriptors.COIN);
        loseSound = assetManager.get(AssetDescriptors.LOSE);




    }

    @Override
    public void render(float delta) {
        GdxUtils.clearScreen();



    }

    @Override
    public void resize(int width, int height) {
        abismo.resize(width, height);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        abismo.dispose();
    }
}
