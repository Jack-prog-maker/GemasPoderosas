package com.blackhole.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.blackhole.game.common.FloatingScore;
import com.blackhole.game.common.GameManager;
import com.blackhole.game.common.GameState;
import com.blackhole.game.common.SoundListener;
import com.blackhole.game.menu.GameOverOverlay;
import com.blackhole.game.menu.MenuOverlay;
import com.blackhole.game.menu.OverlayCallback;

import java.util.Random;

import javax.xml.bind.Unmarshaller;

public class Abismo extends ScreenAdapter {

    private SpriteBatch batch;
    private Texture gameOver;
    private Random numeroRandomico;
    private BitmapFont font;
    private BitmapFont mensagem;
    private BitmapFont gravidtexto;
    private Circle badecirculo;
    private Rectangle retanguloCanoTopoI;
    private Rectangle retanguloCanoBaixoI;
    private Rectangle retanguloCanoTopo1;
    private Rectangle retanguloCanoBaixo1;
    private Rectangle retanguloCanoTopo2;
    private Rectangle retanguloCanoBaixo2;
    private Rectangle retanguloCanoTopo3;
    private Rectangle retanguloCanoBaixo3;
    private Rectangle retanguloCanoTopo4;
    private Rectangle retanguloCanoBaixo4;
    private Rectangle retanguloCanoTopo5;
    private Rectangle retanguloCanoBaixo5;
    private Rectangle retanguloCanoTopo6;
    private Rectangle retanguloCanoBaixo6;
    private Rectangle retanguloCanoTopo7;
    private Rectangle retanguloCanoBaixo7;
    private Rectangle retanguloCanoTopo8;
    private Rectangle retanguloCanoBaixo8;
    private Rectangle retanguloCanoTopo9;
    private Rectangle retanguloCanoBaixo9;
    private Rectangle retanguloCanoTopo10;
    private Rectangle retanguloCanoBaixo10;

    private Circle circulomoedaI;
    private Circle circulomoeda1;
    private Circle circulomoeda2;
    private Circle circulomoeda3;
    private Circle circulomoeda4;
    private Circle circulomoeda5;
    private Circle circulomoeda6;
    private Circle circulomoeda7;
    private Circle circulomoeda8;
    private Circle circulomoeda9;
    private Circle circulomoeda10;
    private Circle circulantg;


    //Atributos de configuracao
    private float larguraDispositivo;
    private float alturaDispositivo;
    private int estadoJogo = 0;// 0-> jogo não iniciado 1-> jogo iniciado 2-> Game Over
    private int pontuacao = 0;
    private int highscore = 0;
    private int pontuacao2 = 0;

    private float variacao = 0;
    private float posicaoI;
    private float posicao1;
    private float posicao2;
    private float posicao3;
    private float posicao4;
    private float posicao5;
    private float posicao6;
    private float posicao7;
    private float posicao8;
    private float posicao9;
    private float posicao10;
    private float posicao11;
    private float posicao12;
    private float posicao13;
    private float posicao14;
    private float posicao15;
    private float posicao16;
    private float posicao17;
    private float posicao18;
    private float posicao19;
    private float posicao20;
    private float posicaomI;
    private float posicaom1;
    private float posicaom2;
    private float posicaom3;
    private float posicaom4;
    private float posicaom5;
    private float posicaom6;
    private float posicaom7;
    private float posicaom8;
    private float posicaom9;
    private float posicaom10;
    private float posicaoAntG;
    private float espacoEntreCanos;
    private float deltaTime;
    private Vector3 mpass;
    private Vector control;
    private float alturaEntreCanosRandomica0;
    private float alturaEntreCanosRandomica1;
    private float alturaEntreCanosRandomica2;
    private float alturaEntreCanosRandomica3;
    private float alturaEntreCanosRandomica4;
    private float alturaEntreCanosRandomica5;
    private float alturaEntreCanosRandomica6;
    private float alturaEntreCanosRandomica7;
    private float alturaEntreCanosRandomica8;
    private float alturaEntreCanosRandomica9;
    private float alturaEntreCanosRandomica10;

    private float randomt;

    private float vel = 600;
    private float scorecont = 70;

    //Câmera
    private OrthographicCamera camera;
    private Viewport viewport;
    private final float VIRTUAL_WIDTH = 768;
    private final float VIRTUAL_HEIGHT = 1024;

    private Animation<TextureRegion> fundo;
    private Texture Bade;

    private Texture d1;
    private Texture d2;
    private Texture e1;
    private Texture e2;
    private Texture e3;
    private Texture moeda;
    private Texture antG;
    private float elapsed;
    private Sprite BadeSprite;
    private Sprite spriteanim;
    private float tamanhaD;
    private GameBase game;
    private GameState gameState = GameState.MENU;
    private final SoundListener listener;

    private float coinTimer;
    private float obstacleTimer;

    private float startWaitTimer = 3f;
    private float animationTime;
    private OverlayCallback callback;

    private final Array<FloatingScore> floatingScores = new Array<FloatingScore>();
    private Pool<FloatingScore> floatingScorePool = Pools.get(FloatingScore.class);

    private Sound coinSound;
    private Sound loseSound;

    private Viewport hudViewport;

    private final AssetManager assetManager;


    private Stage hudStage;
    private MenuOverlay menuOverlay;
    private GameOverOverlay gameOverOverlay;
    private int i;


    private final GlyphLayout layout = new GlyphLayout();

    private DebugCameraController debugCameraController;


    public Abismo(final GameBase game) {
        this.game = game;
        this.assetManager = game.getAssetManager();

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


        callback = new OverlayCallback() {
            @Override
            public void home() {
                gameState = GameState.MENU;
            }

            @Override
            public void ready() {
                restart();
                gameState = GameState.READY;
            }
        };


    }


    @Override
    public void show() {

        batch = new SpriteBatch();
        numeroRandomico = new Random();
        badecirculo = new Circle();
        circulomoedaI = new Circle();
        circulomoeda1 = new Circle();
        circulomoeda2 = new Circle();
        circulomoeda3 = new Circle();
        circulomoeda4 = new Circle();
        circulomoeda5 = new Circle();
        circulomoeda6 = new Circle();
        circulomoeda7 = new Circle();
        circulomoeda8 = new Circle();
        circulomoeda9 = new Circle();
        circulomoeda10 = new Circle();
        circulantg = new Circle();

        Bade = new Texture("BadeFeliz.png");
        moeda = new Texture("moeda.png");
        antG = new Texture("moeda2.png");


        e1 = new Texture("dimensaoE.png");
        e2 = new Texture("dimensaoE2.png");
        e3 = new Texture("dimensaoE3.png");

        d1 = new Texture("dimensaoD.png");
        d2 = new Texture("dimensaoD2.png");

        fundo = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("fundo.gif").read());

        BadeSprite = new com.badlogic.gdx.graphics.g2d.Sprite(Bade);


        camera = new OrthographicCamera();
        camera.position.set(VIRTUAL_WIDTH / 2, VIRTUAL_HEIGHT / 2, 0);
        viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

        larguraDispositivo = VIRTUAL_WIDTH;
        alturaDispositivo = VIRTUAL_HEIGHT;
        hudStage = new Stage(viewport, batch);

        coinSound = assetManager.get(AssetDescriptors.COIN);
        loseSound = assetManager.get(AssetDescriptors.LOSE);

        font = assetManager.get(AssetDescriptors.FONT);

        Skin skin = assetManager.get(AssetDescriptors.SKIN);

        menuOverlay = new MenuOverlay(skin, callback);
        gameOverOverlay = new GameOverOverlay(skin, callback);

        hudStage.addActor(menuOverlay);
        hudStage.addActor(gameOverOverlay);
//        hudStage.setDebugAll(true);

        Gdx.input.setInputProcessor(hudStage);
        posicaoAntG = 1200;
        posicaoI = 1100;
        posicao1 = 1300;
        posicao2 = 1500;
        posicao3 = 2000;
        posicao4 = 2300;
        posicao5 = 2600;
        posicao6 = 2800;
        posicao7 = 3000;
        posicao8 = 3500;
        posicao9 = 4000;
        posicao10 = 4300;
        posicao11 = 4300;
        posicao12 = 4800;
        posicao13 = 5000;
        posicao14 = 5300;
        posicao15 = 5800;
        posicao16 = 6100;
        posicao17 = 6300;
        posicao18 = 6600;
        posicao19 = 6700;
        posicao20 = 6700;

        posicaomI = 1100;
        posicaom1 = 1300;
        posicaom2 = 1400;
        posicaom3 = 1500;
        posicaom4 = 1600;
        posicaom5 = 1700;
        posicaom6 = 1800;
        posicaom7 = 3500;
        posicaom8 = 4000;
        posicaom9 = 4500;
        posicaom10 = 5000;

        tamanhaD = 70;
        mpass = new Vector3(Gdx.graphics.getWidth() / 2, 200, 0);


        espacoEntreCanos = 300;


    }

    @Override
    public void render(float delta) {

        update(delta);
        renderGamePlay(delta);
        renderHud();




    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);

    }

    @Override
    public void dispose() {
        batch.dispose();

    }



    private void renderHud() {
        viewport.apply();

        menuOverlay.setVisible(false);
        gameOverOverlay.setVisible(false);

        if (gameState.isPlayingOrReady()) {
            batch.setProjectionMatrix(camera.combined);
            batch.begin();

            drawHud();

            batch.end();
            return;
        }

        if (gameState.isMenu() && !menuOverlay.isVisible()) {
            menuOverlay.updateLabel();
            menuOverlay.setVisible(true);
        } else if (gameState.isGameOver() && !gameOverOverlay.isVisible()) {
            gameOverOverlay.updateLabels();
            gameOverOverlay.setVisible(true);

        }

        hudStage.act();
        hudStage.draw();
    }


    private void drawHud() {
        float padding = 20;

        // high score
        String highScoreString = "HIGH SCORE: " + GameManager.INSTANCE.getDisplayHighScore();
        layout.setText(font, highScoreString);
        font.draw(batch, layout, padding, alturaDispositivo - layout.height);

        // score
        String scoreString = "SCORE: " + GameManager.INSTANCE.getDisplayScore();
        layout.setText(font, scoreString);
        font.draw(batch, layout,
                larguraDispositivo - layout.width - padding,
                alturaDispositivo - layout.height
        );

        if (startWaitTimer >= 0) {
            int waitTime = (int) startWaitTimer;
            String waitTimeString = waitTime == 0 ? "GO!" : "" + waitTime;
            layout.setText(font, waitTimeString);

            font.draw(batch, layout,
                    (larguraDispositivo - layout.width) / 2f,
                    (larguraDispositivo + layout.height) / 2f
            );
        }

        Color oldFontColor = new Color(font.getColor());

        for (FloatingScore floatingScore : floatingScores) {
            layout.setText(font, floatingScore.getScoreString());
            font.setColor(floatingScore.getColor());
            font.draw(batch, layout,
                    floatingScore.getX() - layout.width / 2f,
                    floatingScore.getY() - layout.height / 2f);
        }

        font.setColor(oldFontColor);
    }

    private void renderGamePlay(float delta) {
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        elapsed += Gdx.graphics.getDeltaTime();
        variacao += delta * 10;
        i++;
        BadeSprite.setRotation(i);
        if (variacao > 2) variacao = 0;
        batch.begin();

        drawGamePlay(delta);

        batch.end();

        drawFormas(delta);

    }


    public void update(float delta) {

        if (gameState.isReady() && startWaitTimer > 0) {
            startWaitTimer -= delta;

            if (startWaitTimer <= 0) {
                gameState = GameState.PLAYING;
            }
        }

        if (!gameState.isPlaying()) {
            return;
        }

        animationTime += delta;

        GameManager.INSTANCE.updateDisplayScore(delta);


        for (int i = 0; i < floatingScores.size; i++) {
            FloatingScore floatingScore = floatingScores.get(i);
            floatingScore.update(delta);

            if (floatingScore.isFinished()) {
                floatingScorePool.free(floatingScore);
                floatingScores.removeIndex(i);
            }
        }

        atualizarp(delta, viewport);
        checcolision();

    }

    public void restart() {
        gameState = GameState.READY;
        vel = 400;
        posicaoAntG = numeroRandomico.nextInt(1300) + (1100);
        posicaoI = numeroRandomico.nextInt(1300) + (1100);
        posicao1 = numeroRandomico.nextInt(1600) + (1300);
        posicao2 = numeroRandomico.nextInt(1800) + (1500);
        posicao3 = numeroRandomico.nextInt(2200) + (2000);
        posicao4 = numeroRandomico.nextInt(2600) + (2300);
        posicao5 = numeroRandomico.nextInt(2800) + (2600);
        posicao6 = numeroRandomico.nextInt(2900) + (2800);
        posicao7 = numeroRandomico.nextInt(3600) + (3000);
        posicao8 = numeroRandomico.nextInt(4000) + (3500);
        posicao9 = numeroRandomico.nextInt(4100) + (4000);
        posicao10 = numeroRandomico.nextInt(4600) + (4300);
        posicao11 = numeroRandomico.nextInt(4800) + (4300);
        posicao12 = numeroRandomico.nextInt(4900) + (4800);
        posicao13 = numeroRandomico.nextInt(5200) + (5000);
        posicao14 = numeroRandomico.nextInt(5600) + (5300);
        posicao15 = numeroRandomico.nextInt(6000) + (5800);
        posicao16 = numeroRandomico.nextInt(6400) + (6100);
        posicao17 = numeroRandomico.nextInt(6600) + (6300);
        posicao18 = numeroRandomico.nextInt(6600) + (6300);
        posicao19 = numeroRandomico.nextInt(6600) + (6300);
        posicao20 = numeroRandomico.nextInt(6600) + (6300);

        posicaomI = numeroRandomico.nextInt(1500) + (1250);
        posicaom1 = numeroRandomico.nextInt(1700) + (1250);
        posicaom2 = numeroRandomico.nextInt(1800) + (1650);
        posicaom3 = numeroRandomico.nextInt(2500) + (2000);
        posicaom4 = numeroRandomico.nextInt(3200) + (3050);
        posicaom5 = numeroRandomico.nextInt(3500) + (3250);
        posicaom6 = numeroRandomico.nextInt(3800) + (3250);
        posicaom7 = numeroRandomico.nextInt(5000) + (4250);
        posicaom8 = numeroRandomico.nextInt(6000) + (5650);
        posicaom9 = numeroRandomico.nextInt(6200) + (6000);
        posicaom10 = numeroRandomico.nextInt(6500) + (6250);

        alturaEntreCanosRandomica0 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica1 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica2 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica3 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica4 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica5 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica6 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica7 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica8 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica9 = numeroRandomico.nextInt(400) - 200;
        alturaEntreCanosRandomica10 = numeroRandomico.nextInt(400) - 200;

        tamanhaD = 70;
        floatingScorePool.freeAll(floatingScores);
        floatingScores.clear();

        GameManager.INSTANCE.updateHighScore();
        GameManager.INSTANCE.reset();
        startWaitTimer = 3f;
        animationTime = 0f;
        gameState = GameState.READY;
    }

    private void addFloatingScore(int score) {
        FloatingScore floatingScore = floatingScorePool.obtain();
        floatingScore.setStartPosition(larguraDispositivo / 2f, alturaDispositivo / 2f);
        floatingScore.setScore(score);
        floatingScores.add(floatingScore);
    }

    private void atualizarp(float deltaTime, Viewport viewport) {
        if (Gdx.input.isTouched()) {
            mpass.set(Gdx.input.getX(), 200, 0);
            viewport.unproject(mpass);
        }

            posicaoI -= deltaTime * vel;
            posicao1 -= deltaTime * vel;
            posicao2 -= deltaTime * vel;
            posicao3 -= deltaTime * vel;
            posicao4 -= deltaTime * vel;
            posicao5 -= deltaTime * vel;
            posicao6 -= deltaTime * vel;
            posicao7 -= deltaTime * vel;
            posicao8 -= deltaTime * vel;
            posicao9 -= deltaTime * vel;
            posicao10 -= deltaTime * vel;
        posicao11 -= deltaTime * vel;
        posicao12 -= deltaTime * vel;
        posicao13 -= deltaTime * vel;
        posicao14 -= deltaTime * vel;
        posicao15 -= deltaTime * vel;
        posicao16 -= deltaTime * vel;
        posicao17 -= deltaTime * vel;
        posicao18 -= deltaTime * vel;
        posicao19 -= deltaTime * vel;
        posicao20 -= deltaTime * vel;

        posicaomI -= deltaTime * vel;
        posicaom1 -= deltaTime * vel;
        posicaom2 -= deltaTime * vel;
        posicaom3 -= deltaTime * vel;
        posicaom4 -= deltaTime * vel;
        posicaom5 -= deltaTime * vel;
        posicaom6 -= deltaTime * vel;
        posicaom7 -= deltaTime * vel;
        posicaom8 -= deltaTime * vel;
        posicaom9 -= deltaTime * vel;
        posicaom10 -= deltaTime * vel;


            //Verifica se o cano saiu inteiramente da tela
            if (posicaoI < 0
                    && posicao1 < 0
                    && posicao2 < 0
                    && posicao3 < 0
                    && posicao4 < 0
                    && posicao5 < 0
                    && posicao6 < 0
                    && posicao7 < 0
                    && posicao8 < 0
                    && posicao9 < 0
                    && posicao10 < 0
                    && posicao11 < 0
                    && posicao12 < 0
                    && posicao13 < 0
                    && posicao14 < 0
                    && posicao15 < 0
                    && posicao16 < 0
                    && posicao17 < 0
                    && posicao18 < 0
                    && posicao19 < 0
                    && posicao20 < 0
                    ) {

                posicaoI = numeroRandomico.nextInt(1300) + (1100);
                posicaoAntG = numeroRandomico.nextInt(1300) + (1100);
                posicao1 = numeroRandomico.nextInt(1600) + (1300);
                posicao2 = numeroRandomico.nextInt(1800) + (1500);
                posicao3 = numeroRandomico.nextInt(2200) + (2000);
                posicao4 = numeroRandomico.nextInt(2600) + (2300);
                posicao5 = numeroRandomico.nextInt(2800) + (2600);
                posicao6 = numeroRandomico.nextInt(2900) + (2800);
                posicao7 = numeroRandomico.nextInt(3600) + (3000);
                posicao8 = numeroRandomico.nextInt(4000) + (3500);
                posicao9 = numeroRandomico.nextInt(4100) + (4000);
                posicao10 = numeroRandomico.nextInt(4600) + (4300);
                posicao11 = numeroRandomico.nextInt(4800) + (4300);
                posicao12 = numeroRandomico.nextInt(4900) + (4800);
                posicao13 = numeroRandomico.nextInt(5200) + (5000);
                posicao14 = numeroRandomico.nextInt(5600) + (5300);
                posicao15 = numeroRandomico.nextInt(6000) + (5800);
                posicao16 = numeroRandomico.nextInt(6400) + (6100);
                posicao17 = numeroRandomico.nextInt(6600) + (6300);
                posicao18 = numeroRandomico.nextInt(6600) + (6300);
                posicao19 = numeroRandomico.nextInt(6600) + (6300);
                posicao20 = numeroRandomico.nextInt(6600) + (6300);

                posicaomI = numeroRandomico.nextInt(1500) + (1250);
                posicaom1 = numeroRandomico.nextInt(1700) + (1250);
                posicaom2 = numeroRandomico.nextInt(1800) + (1650);
                posicaom3 = numeroRandomico.nextInt(2500) + (2000);
                posicaom4 = numeroRandomico.nextInt(3200) + (3050);
                posicaom5 = numeroRandomico.nextInt(3500) + (3250);
                posicaom6 = numeroRandomico.nextInt(3800) + (3250);
                posicaom7 = numeroRandomico.nextInt(5000) + (4250);
                posicaom8 = numeroRandomico.nextInt(6000) + (5650);
                posicaom9 = numeroRandomico.nextInt(6200) + (6000);
                posicaom10 = numeroRandomico.nextInt(6500) + (6250);

                alturaEntreCanosRandomica0 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica1 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica2 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica3 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica4 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica5 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica6 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica7 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica8 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica9 = numeroRandomico.nextInt(400) - 200;
                alturaEntreCanosRandomica10 = numeroRandomico.nextInt(400) - 200;
                vel = vel + 100;


            }



        }

    private void drawGamePlay(float delta){



        batch.draw(fundo.getKeyFrame(elapsed), 0, 0, larguraDispositivo, alturaDispositivo);


        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao2, tamanhaD, tamanhaD);

        batch.draw(d2, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao3, tamanhaD, tamanhaD);
        batch.draw(e3, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao4, tamanhaD, tamanhaD);

        batch.draw(d2, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao5, tamanhaD, tamanhaD);
        batch.draw(e3, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao6, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao7, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao8, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao9, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao10, tamanhaD, tamanhaD);

        batch.draw(e1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao11, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao12, tamanhaD, tamanhaD);

        batch.draw(e1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao13, tamanhaD, tamanhaD);
        batch.draw(e3, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao14, tamanhaD, tamanhaD);

        batch.draw(d2, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao15, tamanhaD, tamanhaD);
        batch.draw(d1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao16, tamanhaD, tamanhaD);

        batch.draw(e1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao17, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao18, tamanhaD, tamanhaD);

        batch.draw(e2, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao19, tamanhaD, tamanhaD);
        batch.draw(e3, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao20, tamanhaD, tamanhaD);
        batch.draw(d2, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI, tamanhaD, tamanhaD);


        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaomI, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica1, posicaom1, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica2, posicaom2, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica3, posicaom3, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica4, posicaom4, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica5, posicaom5, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica6, posicaom6, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica7, posicaom7, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica8, posicaom8, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica9, posicaom9, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica10, posicaom10, 50, 50);


        if (vel > 2500){
            batch.draw(antG, larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaoAntG, 100, 100);
        }else if (vel > 2000){
            batch.draw(antG, larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaoAntG, 100, 100);
        }else if (vel > 1900){
            batch.draw(antG, larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaoAntG, 100, 100);
        }else if (vel > 1600){
            batch.draw(antG, larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaoAntG, 100, 100);
        }else if (vel > 1000){
            batch.draw(antG, larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaoAntG, 100, 100);
        }

        batch.draw(BadeSprite, mpass.x, 200);



    }
    private void drawFormas(float delta){
        badecirculo.set(mpass.x + Bade.getWidth() / 2, 200 + Bade.getHeight() / 2, 30);

        circulantg.set(larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaoAntG, 30);

        circulomoedaI.set(larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaomI, 30);
        circulomoeda1.set(larguraDispositivo / 2 + alturaEntreCanosRandomica1, posicaom1, 30);
        circulomoeda2.set(larguraDispositivo / 2 + alturaEntreCanosRandomica2, posicaom2, 30);
        circulomoeda3.set(larguraDispositivo / 2 + alturaEntreCanosRandomica3, posicaom3, 30);
        circulomoeda4.set(larguraDispositivo / 2 + alturaEntreCanosRandomica4, posicaom4, 30);
        circulomoeda5.set(larguraDispositivo / 2 + alturaEntreCanosRandomica5, posicaom5, 30);
        circulomoeda6.set(larguraDispositivo / 2 + alturaEntreCanosRandomica6, posicaom6, 30);
        circulomoeda7.set(larguraDispositivo / 2 + alturaEntreCanosRandomica7, posicaom7, 30);
        circulomoeda8.set(larguraDispositivo / 2 + alturaEntreCanosRandomica8, posicaom8, 30);
        circulomoeda9.set(larguraDispositivo / 2 + alturaEntreCanosRandomica9, posicaom9, 30);
        circulomoeda10.set(larguraDispositivo / 2 + alturaEntreCanosRandomica10, posicaom10, 30);



        retanguloCanoBaixoI = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopoI = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo1 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao2,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo1 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao3,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo2 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao4,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo2 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao5,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo3 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao6,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo3 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao7,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo4 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao8,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo4 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao9,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo5 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao10,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo5 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao11,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo6 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao12,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo6 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao13,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo7 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao14,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo7 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao15,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo8 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao16,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo8 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao17,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo9 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao18,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo9 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao19,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo10 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao20,
                tamanhaD, tamanhaD
        );

    }
    private void checcolision(){
        //Teste de colisão
        if (Intersector.overlaps(badecirculo, retanguloCanoBaixoI) || Intersector.overlaps(badecirculo, retanguloCanoTopoI)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo1) || Intersector.overlaps(badecirculo, retanguloCanoTopo1)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo2) || Intersector.overlaps(badecirculo, retanguloCanoTopo2)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo3) || Intersector.overlaps(badecirculo, retanguloCanoTopo3)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo4) || Intersector.overlaps(badecirculo, retanguloCanoTopo4)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo5) || Intersector.overlaps(badecirculo, retanguloCanoTopo5)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo6) || Intersector.overlaps(badecirculo, retanguloCanoTopo6)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo7) || Intersector.overlaps(badecirculo, retanguloCanoTopo7)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo8) || Intersector.overlaps(badecirculo, retanguloCanoTopo8)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo9) || Intersector.overlaps(badecirculo, retanguloCanoTopo9)
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo10)))))))))))) {
            //Gdx.app.log("Colisão", "Houve colisão");
            listener.lose();
            gameState = GameState.GAME_OVER;



        }else if (Intersector.overlaps(badecirculo, circulomoedaI)){
            posicaomI = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();

        }else if (Intersector.overlaps(badecirculo, circulomoeda1)){
            posicaom1 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();

        }else if (Intersector.overlaps(badecirculo, circulomoeda2)){
            posicaom2 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();


        }else if (Intersector.overlaps(badecirculo, circulomoeda3)){
            posicaom3 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();
        }else if (Intersector.overlaps(badecirculo, circulomoeda4)){
            posicaom4 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();
        }else if (Intersector.overlaps(badecirculo, circulomoeda5)){
            posicaom5 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();
        }else if (Intersector.overlaps(badecirculo, circulomoeda6)){
            posicaom6 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();
        }else if (Intersector.overlaps(badecirculo, circulomoeda7)){
            posicaom7 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();
        }else if (Intersector.overlaps(badecirculo, circulomoeda8)){
            posicaom8 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();
        }else if (Intersector.overlaps(badecirculo, circulomoeda9)){
            posicaom9 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();
        }else if (Intersector.overlaps(badecirculo, circulomoeda10)) {
            posicaom10 = 100000;
            GameManager.INSTANCE.addScore(50);
            addFloatingScore(50);
            listener.hitCoin();



        }else if (Intersector.overlaps(badecirculo, circulantg)){
            vel = vel - 50;
            listener.hitCoin();
        }
    }

}