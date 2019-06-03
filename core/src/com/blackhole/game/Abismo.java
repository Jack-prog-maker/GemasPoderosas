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

    private float vel = 400;
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
    private Texture moeda;
    private Texture antG;
    private Texture[] dimensaoD;
    private Texture[] Abs;
    private float elapsed;
    private Sprite BadeSprite;
    private Sprite spriteanim;
    private float tamanhaD;
    private final GameBase game;
    private GameState gameState = GameState.MENU;
    private SoundListener listener;

    private float coinTimer;
    private float obstacleTimer;

    private float startWaitTimer = 3f;
    private float animationTime;
    private OverlayCallback callback;

    private final Array<FloatingScore> floatingScores = new Array<FloatingScore>();
    private Pool<FloatingScore> floatingScorePool = Pools.get(FloatingScore.class);

    private Sound coinSound;
    private Sound loseSound;
    private final AssetManager assetManager;

    private Stage hudStage;
    private MenuOverlay menuOverlay;
    private GameOverOverlay gameOverOverlay;

    private final GlyphLayout layout = new GlyphLayout();


    public Abismo(GameBase game, SoundListener listener, AssetManager assetManager) {
        this.listener = listener;
        this.game = game;
        this.assetManager = assetManager;

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

        gravidtexto = new BitmapFont();
        gravidtexto.setColor(Color.LIGHT_GRAY);
        gravidtexto.getData().setScale(4);

        mensagem = new BitmapFont();
        mensagem.setColor(Color.BLUE);
        mensagem.getData().setScale(3);


        Bade = new Texture("BadeFeliz.png");
        moeda = new Texture("moeda.png");
        antG = new Texture("moeda2.png");


        e1 = new Texture("e1.png");
        e2 = new Texture("e12.png");

        d1 = new Texture("dimensaoD.png");
        d2 = new Texture("dimensaoD2.png");


        BadeSprite = new com.badlogic.gdx.graphics.g2d.Sprite(Bade);
        gameOver = new Texture("gameover.png");

        coinSound = assetManager.get(AssetDescriptors.COIN);
        loseSound = assetManager.get(AssetDescriptors.LOSE);


        /**********************************************
         * Configuração da câmera
         * */
        camera = new OrthographicCamera();
        camera.position.set(VIRTUAL_WIDTH / 2, VIRTUAL_HEIGHT / 2, 0);
        viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

        larguraDispositivo = VIRTUAL_WIDTH;
        alturaDispositivo = VIRTUAL_HEIGHT;
        hudStage = new Stage(viewport, batch);
        fundo = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("fundo.gif").read());
        font = assetManager.get(AssetDescriptors.FONT);

        Skin skin = assetManager.get(AssetDescriptors.SKIN);

        menuOverlay = new MenuOverlay(skin, getCallback());
        gameOverOverlay = new GameOverOverlay(skin, getCallback());

        hudStage.addActor(menuOverlay);
        hudStage.addActor(gameOverOverlay);
//        hudStage.setDebugAll(true);

        Gdx.input.setInputProcessor(hudStage);

        posicaoAntG = -50;
        posicaoI = -50;
        posicao1 = -500;
        posicao2 = -1000;
        tamanhaD = 200;
        mpass = new Vector3(Gdx.graphics.getWidth() / 2, 0, 0);


        espacoEntreCanos = 300;


    }

    @Override
    public void render(float deltaTime) {

        camera.update();
        // Limpar frames anteriores
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        deltaTime = Gdx.graphics.getDeltaTime();
        variacao += deltaTime * 10;
        elapsed += Gdx.graphics.getDeltaTime();
        if (variacao > 2) variacao = 0;
        //Configurar dados de projeção da câmera
        batch.setProjectionMatrix(camera.combined);

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


        if (!gameState.isPlaying()) {
            return;
        }

        batch.begin();
        drawGamePlay(deltaTime);
        batch.end();
        drawFormas(deltaTime);
        renderHud();
        checcolision();





    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public Array<FloatingScore> getFloatingScores() {
        return floatingScores;
    }

    public float getStartWaitTimer() {
        return startWaitTimer;
    }

    public float getAnimationTime() {
        return animationTime;
    }

    public GameState getGameState() {
        return gameState;
    }

    public OverlayCallback getCallback() {
        return callback;
    }


    private void renderHud() {
        viewport.apply();

        menuOverlay.setVisible(false);
        gameOverOverlay.setVisible(false);

        GameState gameState = getGameState();

        if (gameState.isPlayingOrReady()) {
            batch.setProjectionMatrix(viewport.getCamera().combined);
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

        float startWaitTimer = getStartWaitTimer();

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

        for (FloatingScore floatingScore : getFloatingScores()) {
            layout.setText(font, floatingScore.getScoreString());
            font.setColor(floatingScore.getColor());
            font.draw(batch, layout,
                    floatingScore.getX() - layout.width / 2f,
                    floatingScore.getY() - layout.height / 2f);
        }

        font.setColor(oldFontColor);
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

        atualizarp();

    }

    public void restart() {
        gameState = GameState.READY;
        vel = 400;
        posicaoI = -50;
        posicao1 = -500;
        posicao2 = -1000;
        posicao3 = -1500;
        posicao4 = -2000;
        posicao5 = -2500;
        posicao6 = -3000;
        posicao7 = -3500;
        posicao8 = -4000;
        posicao9 = -4500;
        posicao10 = -5000;
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

    private void atualizarp() {
        if (Gdx.input.isTouched()) {
            mpass.set(Gdx.input.getX(), 650, 0);
        }


        if (estadoJogo == 1) {//iniciado

            posicaoI += deltaTime * vel;
            posicao1 += deltaTime * vel;
            posicao2 += deltaTime * vel;
            posicao3 += deltaTime * vel;
            posicao4 += deltaTime * vel;
            posicao5 += deltaTime * vel;
            posicao6 += deltaTime * vel;
            posicao7 += deltaTime * vel;
            posicao8 += deltaTime * vel;
            posicao9 += deltaTime * vel;
            posicao10 += deltaTime * vel;


            //Verifica se o cano saiu inteiramente da tela
            if (posicaoI > 1000
                    && posicao1 > 1000
                    && posicao2 > 1000
                    && posicao3 > 1000
                    && posicao4 > 1000
                    && posicao5 > 1000
                    && posicao6 > 1000
                    && posicao7 > 1000
                    && posicao8 > 1000
                    && posicao9 > 1000
                    && posicao10 > 1000
                    ) {

                posicaoI = -50;
                posicao1 = -500;
                posicao2 = -1000;
                posicao3 = -1500;
                posicao4 = -2000;
                posicao5 = -2500;
                posicao6 = -3000;
                posicao7 = -3500;
                posicao8 = -4000;
                posicao9 = -4500;
                posicao10 = -5000;
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
                randomt = numeroRandomico.nextInt(200) + 100;
                if (vel > 1000) {
                    vel = vel + 3;
                } else if (vel > 650) {
                    vel = vel + 20;
                } else {
                    vel = vel + 80;
                }

            }

            for (int i = 0; i < floatingScores.size; i++) {
                FloatingScore floatingScore = floatingScores.get(i);
                floatingScore.update(deltaTime);

                if (floatingScore.isFinished()) {
                    floatingScorePool.free(floatingScore);
                    floatingScores.removeIndex(i);
                }
            }

        }


    }

    private void drawGamePlay(float deltaTime){



        batch.draw(fundo.getKeyFrame(elapsed), 0, 0, larguraDispositivo, alturaDispositivo);


        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao2, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao2, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao3, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao3, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao4, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao4, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao5, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao5, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao6, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao6, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao7, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao7, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao8, tamanhaD, tamanhaD);
        batch.draw(d1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao8, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao9, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao9, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao10, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao10, tamanhaD, tamanhaD);

        batch.draw(d1, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI, tamanhaD, tamanhaD);
        batch.draw(e1, larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI, tamanhaD, tamanhaD);


        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaoI, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica1, posicao1, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica2, posicao2, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica3, posicao3, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica4, posicao4, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica5, posicao5, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica6, posicao6, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica7, posicao7, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica8, posicao8, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica9, posicao9, 50, 50);
        batch.draw(moeda, larguraDispositivo / 2 + alturaEntreCanosRandomica10, posicao10, 50, 50);

        if (vel > 600){
            batch.draw(antG, larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaoAntG, 50, 50);
        }


        batch.draw(Bade, mpass.x, 650);



    }
    private void drawFormas(float deltaTime){
        badecirculo.set(mpass.x + Bade.getWidth() / 2, 650 + Bade.getHeight() / 2, 30);

        circulomoedaI.set(larguraDispositivo / 2 + alturaEntreCanosRandomica0, posicaoI, 30);
        circulomoeda1.set(larguraDispositivo / 2 + alturaEntreCanosRandomica1, posicao1, 30);
        circulomoeda2.set(larguraDispositivo / 2 + alturaEntreCanosRandomica2, posicao2, 30);
        circulomoeda3.set(larguraDispositivo / 2 + alturaEntreCanosRandomica3, posicao3, 30);
        circulomoeda4.set(larguraDispositivo / 2 + alturaEntreCanosRandomica4, posicao4, 30);
        circulomoeda5.set(larguraDispositivo / 2 + alturaEntreCanosRandomica5, posicao5, 30);
        circulomoeda6.set(larguraDispositivo / 2 + alturaEntreCanosRandomica6, posicao6, 30);
        circulomoeda7.set(larguraDispositivo / 2 + alturaEntreCanosRandomica7, posicao7, 30);
        circulomoeda8.set(larguraDispositivo / 2 + alturaEntreCanosRandomica8, posicao8, 30);
        circulomoeda9.set(larguraDispositivo / 2 + alturaEntreCanosRandomica9, posicao9, 30);
        circulomoeda10.set(larguraDispositivo / 2 + alturaEntreCanosRandomica10, posicao10, 30);



        retanguloCanoBaixoI = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopoI = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo1 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo1 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo2 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao2,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo2 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao2,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo3 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao3,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo3 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao3,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo4 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao4,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo4 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao4,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo5 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao5,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo5 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao5,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo6 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao6,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo6 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao6,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo7 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao7,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo7 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao7,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo8 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao8,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo8 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao8,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo9 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao9,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo9 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao9,
                tamanhaD, tamanhaD
        );

        retanguloCanoBaixo10 = new Rectangle(
                larguraDispositivo / 2 - tamanhaD - espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao10,
                tamanhaD, tamanhaD
        );

        retanguloCanoTopo10 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao10,
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
                || (Intersector.overlaps(badecirculo, retanguloCanoBaixo10) || Intersector.overlaps(badecirculo, retanguloCanoTopo10)))))))))))) {
            //Gdx.app.log("Colisão", "Houve colisão");
            listener.lose();
            gameState = GameState.GAME_OVER;



        }else if (Intersector.overlaps(badecirculo, circulomoedaI)
                || (Intersector.overlaps(badecirculo, circulomoeda1)
                || (Intersector.overlaps(badecirculo, circulomoeda2)
                || (Intersector.overlaps(badecirculo, circulomoeda3)
                || (Intersector.overlaps(badecirculo, circulomoeda4)
                || (Intersector.overlaps(badecirculo, circulomoeda5)
                || (Intersector.overlaps(badecirculo, circulomoeda6)
                || (Intersector.overlaps(badecirculo, circulomoeda7)
                || (Intersector.overlaps(badecirculo, circulomoeda8)
                || (Intersector.overlaps(badecirculo, circulomoeda9)
                || (Intersector.overlaps(badecirculo, circulomoeda10)))))))))))) {

            GameManager.INSTANCE.addScore(5);
            addFloatingScore(5);
            listener.hitCoin();



        }else if (Intersector.overlaps(badecirculo, circulantg)){
            vel = vel - 50;
            listener.hitCoin();
        }
    }

}