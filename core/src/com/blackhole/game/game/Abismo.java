package com.blackhole.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.blackhole.game.Assets.AssetDescriptors;
import com.blackhole.game.Assets.RegionNames;
import com.blackhole.game.DebugCameraController;
import com.blackhole.game.GameBase;
import com.blackhole.game.GameConfig;
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
    private Random numeroRandomico;
    private BitmapFont font;

    //Atributos de configuracao
    private float larguraDispositivo;
    private float alturaDispositivo;

    private float variacao = 0;

    private Vector3 mpass;

    private float posicaoX1;
    private float posicaoX2;
    private float posicaoX3;
    private float posicaoX4;

    private float posicaoY1;
    private float posicaoY2;
    private float posicaoY3;
    private float posicaoY4;

    private float posicaoXM1;
    private float posicaoXM2;
    private float posicaoXM3;
    private float posicaoXM4;

    private float posicaoYM1;
    private float posicaoYM2;
    private float posicaoYM3;
    private float posicaoYM4;

    //Câmera
    private OrthographicCamera camera;
    private Viewport viewport;
    private final float VIRTUAL_WIDTH = 768;
    private final float VIRTUAL_HEIGHT = 1024;


    private TextureRegion badegema1;
    private TextureRegion badegema2;
    private TextureRegion badegema3;
    private TextureRegion badegema4;
    private TextureRegion baldegema1;
    private TextureRegion baldegema2;
    private TextureRegion baldegema3;
    private TextureRegion baldegema4;
    private TextureRegion gema1;
    private TextureRegion gema2;
    private TextureRegion gema3;
    private TextureRegion gema4;
    private TextureRegion botao1;
    private TextureRegion botao2;
    private TextureRegion botao3;
    private TextureRegion botao4;
    private TextureRegion fundo;
    private TextureRegion controleE;
    private TextureRegion controleD;
    private TextureRegion logo;

    private GameBase game;
    private GameState gameState = GameState.MENU;
    private final SoundListener listener;

    private float startWaitTimer = 3f;
    private float animationTime;
    private OverlayCallback callback;

    private final Array<FloatingScore> floatingScores = new Array<FloatingScore>();
    private Pool<FloatingScore> floatingScorePool = Pools.get(FloatingScore.class);

    private Sound coinSound;
    private Sound loseSound;
    private Sound jumpSound;

    private final AssetManager assetManager;

    private Stage hudStage;
    private Stage cenario;
    private Image jogador;
    private MenuOverlay menuOverlay;
    private GameOverOverlay gameOverOverlay;

    private float vel;
    private float velM1;
    private float velM2;
    private float velM3;
    private float velM4;

    private float botaon;

    private final GlyphLayout layout = new GlyphLayout();

    private Rectangle badegemaR1;
    private Rectangle badegemaR2;
    private Rectangle badegemaR3;
    private Rectangle badegemaR4;

    private Rectangle baldegemaR1;
    private Rectangle baldegemaR2;
    private Rectangle baldegemaR3;
    private Rectangle baldegemaR4;

    private Rectangle gemaR1;
    private Rectangle gemaR2;
    private Rectangle gemaR3;
    private Rectangle gemaR4;

    private Rectangle botaoR1;
    private Rectangle botaoR2;
    private Rectangle botaoR3;
    private Rectangle botaoR4;

    private Rectangle controleRE;
    private Rectangle controleRD;

    private float botaogema = GameConfig.BOTAOGEMA_SIZE;

    private float gema1WSIZE = GameConfig.GEMA1W_SIZE;
    private float gema1HSIZE = GameConfig.GEMA1H_SIZE;

    private float gema2WSIZE = GameConfig.GEMA2W_SIZE;
    private float gema2HSIZE = GameConfig.GEMA2H_SIZE;

    private float gema3WSIZE = GameConfig.GEMA3W_SIZE;
    private float gema3HSIZE = GameConfig.GEMA3H_SIZE;

    private float gema4WSIZE = GameConfig.GEMA4W_SIZE;
    private float gema4HSIZE = GameConfig.GEMA4H_SIZE;

    private float badegemaWSIZE = GameConfig.BADEGEMASW_SIZE;
    private float badegemaHSIZE = GameConfig.BADEGEMASW_SIZE;


    private Vector2 touch = new Vector2();
    private Vector2 touchControl = new Vector2();
    private Vector2 touchTiro = new Vector2();
    private float PHbalde;
    private float PHbalde2;
    private float PHbalde3;
    private float PHbalde4;
    private float PWbalde;

    private float CEH;
    private float CEW;
    private float CDH;
    private float CDW;

    private int qbalde1;
    private int qbalde2;
    private int qbalde3;
    private int qbalde4;

    private Array<Image> tiros1 = new Array<Image>();
    private Array<Image> tiros2 = new Array<Image>();
    private Array<Image> tiros3 = new Array<Image>();
    private Array<Image> tiros4 = new Array<Image>();

    private float velocidadeTiro = 250;
    private boolean atirando = false;
    private int intervaloTiros = 350;

    private Sprite BG;
    private int i;








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

            @Override
            public void jump() {
                jumpSound.play();

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

        camera = new OrthographicCamera();
        camera.position.set(VIRTUAL_WIDTH / 2, VIRTUAL_HEIGHT / 2, 0);
        viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

        larguraDispositivo = VIRTUAL_WIDTH;
        alturaDispositivo = VIRTUAL_HEIGHT;
        hudStage = new Stage(viewport, batch);
        cenario = new Stage(viewport, batch);



        coinSound = assetManager.get(AssetDescriptors.COIN);
        loseSound = assetManager.get(AssetDescriptors.LOSE);
        jumpSound = assetManager.get(AssetDescriptors.JUMP);

        font = assetManager.get(AssetDescriptors.FONT);

        Skin skin = assetManager.get(AssetDescriptors.SKIN);

        TextureAtlas gamePlayAtlas = assetManager.get(AssetDescriptors.GAME_PLAY);


        badegema1 = gamePlayAtlas.findRegion(RegionNames.BADEGEMA1);
        badegema2 = gamePlayAtlas.findRegion(RegionNames.BADEGEMA2);
        badegema3 = gamePlayAtlas.findRegion(RegionNames.BADEGEMA3);
        badegema4 = gamePlayAtlas.findRegion(RegionNames.BADEGEMA4);


        baldegema1 = gamePlayAtlas.findRegion(RegionNames.BALDEGEMA1);
        baldegema2 = gamePlayAtlas.findRegion(RegionNames.BALDEGEMA2);
        baldegema3 = gamePlayAtlas.findRegion(RegionNames.BALDEGEMA3);
        baldegema4 = gamePlayAtlas.findRegion(RegionNames.BALDEGEMA4);

        botao1 = gamePlayAtlas.findRegion(RegionNames.BOTAO1);
        botao2 = gamePlayAtlas.findRegion(RegionNames.BOTAO2);
        botao3 = gamePlayAtlas.findRegion(RegionNames.BOTAO3);
        botao4 = gamePlayAtlas.findRegion(RegionNames.BOTAO4);

        gema1 = gamePlayAtlas.findRegion(RegionNames.GEMA1);
        gema2 = gamePlayAtlas.findRegion(RegionNames.GEMA2);
        gema3 = gamePlayAtlas.findRegion(RegionNames.GEMA3);
        gema4 = gamePlayAtlas.findRegion(RegionNames.GEMA4);

        fundo = gamePlayAtlas.findRegion(RegionNames.FUNDO);
        logo = gamePlayAtlas.findRegion(RegionNames.LOGO);
        controleD = gamePlayAtlas.findRegion(RegionNames.CONTROLED);
        controleE = gamePlayAtlas.findRegion(RegionNames.CONTROLEE);


        menuOverlay = new MenuOverlay(skin, callback);
        gameOverOverlay = new GameOverOverlay(skin, callback);

        hudStage.addActor(menuOverlay);
        hudStage.addActor(gameOverOverlay);
//        hudStage.setDebugAll(true);

        Gdx.input.setInputProcessor(hudStage);

        posicaoX1 = 100;
        posicaoX2 = 200;
        posicaoX3 = 400;
        posicaoX4 = 500;

        posicaoY1 = 1300;
        posicaoY2 = 1500;
        posicaoY3 = 2000;
        posicaoY4 = 2300;

        posicaoXM1 = 100;
        posicaoXM2 = 200;
        posicaoXM3 = 400;
        posicaoXM4 = 500;

        posicaoYM1 = 3000;
        posicaoYM2 = 4000;
        posicaoYM3 = 5000;
        posicaoYM4 = 6000;

        PHbalde = 240;
        PHbalde2 = -340;
        PHbalde3 = -340;
        PHbalde4 = -340;
        PWbalde = 90;
        mpass = new Vector3(Gdx.graphics.getWidth() / 2, 200, 0);

        vel = 200;
        velM1 = 60;
        velM2 = 60;
        velM3 = 60;
        velM4 = 60;


        CEH = 0;
        CEW = 360;
        CDH = 0;
        CDW = 120;







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
        String highScoreString = "MAX BADE: " + GameManager.INSTANCE.getDisplayHighScore();
        layout.setText(font, highScoreString);
        font.draw(batch, layout, padding, alturaDispositivo - layout.height);

        // score
        String scoreString = "CAP. BADE: " + GameManager.INSTANCE.getDisplayScore();
        layout.setText(font, scoreString);
        font.draw(batch, layout, padding, alturaDispositivo - layout.height - 100);

        String qB1 = "" + qbalde1;
        layout.setText(font, qB1);
        font.draw(batch, layout, 30, 640);

        String qB2 = "" + qbalde2;
        layout.setText(font, qB2);
        font.draw(batch, layout, 30, 440);

        String qB3 = "" + qbalde3;
        layout.setText(font, qB3);
        font.draw(batch, layout, larguraDispositivo - 80, 640);

        String qB4 = "" + qbalde4;
        layout.setText(font, qB4);
        font.draw(batch, layout, larguraDispositivo - 80, 440);

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
        variacao += delta * 10;
        if (variacao > 2) variacao = 0;
        batch.begin();

        drawGamePlay();

        batch.end();

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

        i++;


        atualizarp(delta, viewport);
        drawFormas();
        mudarBalde(viewport);
        moverbalde(viewport, delta);
        retsoma();
        atirar(viewport);
        atualizarTiros(delta);


    }

    public void restart() {
        gameState = GameState.READY;

        posicaoY1 = numeroRandomico.nextInt(1300) + (1100);
        posicaoY2 = numeroRandomico.nextInt(1500) + (1300);
        posicaoY3 = numeroRandomico.nextInt(1600) + (1500);
        posicaoY4 = numeroRandomico.nextInt(2000) + (1600);
        posicaoYM1 = numeroRandomico.nextInt(2200) + (2000);
        posicaoYM2 = numeroRandomico.nextInt(3200) + (3000);
        posicaoYM3 = numeroRandomico.nextInt(4200) + (4000);
        posicaoYM4 = numeroRandomico.nextInt(5200) + (5000);

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


        posicaoY1 -= deltaTime * vel;
        posicaoY2 -= deltaTime * vel;
        posicaoY3 -= deltaTime * vel;
        posicaoY4 -= deltaTime * vel;

        posicaoYM1 -= deltaTime * velM1;
        posicaoYM2 -= deltaTime * velM2;
        posicaoYM3 -= deltaTime * velM3;
        posicaoYM4 -= deltaTime * velM4;


        if (posicaoYM1 < 70){
            posicaoYM1 = numeroRandomico.nextInt(2200) + (2000);
        }else if (posicaoYM2 < 70){
            posicaoYM2 = numeroRandomico.nextInt(3200) + (3000);
        }else if (posicaoYM3 < 70){
            posicaoYM3 = numeroRandomico.nextInt(4200) + (4000);
        }else if (posicaoYM4 < 70){
            posicaoYM4 = numeroRandomico.nextInt(5200) + (5000);
        }else if (posicaoY1 < 70){
            posicaoY1 = numeroRandomico.nextInt(1300) + (1100);
        }else if (posicaoY2 < 70){
            posicaoY2 = numeroRandomico.nextInt(1500) + (1300);
        }else if (posicaoY3 < 70){
            posicaoY3 = numeroRandomico.nextInt(1600) + (1500);
        }else if (posicaoY4 < 70){
            posicaoY4 = numeroRandomico.nextInt(2000) + (1600);

        }



    }


    private void drawGamePlay(){



        batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);


        batch.draw(gema1, posicaoX1, posicaoY1, gema1WSIZE, gema1HSIZE);
        batch.draw(gema2, posicaoX2, posicaoY2, gema2WSIZE, gema2HSIZE);
        batch.draw(gema3, posicaoX3, posicaoY3, gema3WSIZE, gema3HSIZE);
        batch.draw(gema4, posicaoX4, posicaoY4, gema4WSIZE, gema4HSIZE);

        batch.draw(badegema1, posicaoXM1, posicaoYM1, 236, 238,
                badegemaWSIZE, badegemaHSIZE, 0, 0, i++);
        batch.draw(badegema2, posicaoXM2, posicaoYM2, badegemaWSIZE, badegemaHSIZE);
        batch.draw(badegema3, posicaoXM3, posicaoYM3, badegemaWSIZE, badegemaHSIZE);
        batch.draw(badegema4, posicaoXM4, posicaoYM4, badegemaWSIZE, badegemaHSIZE);

        if (botaon == 4){
            batch.draw(baldegema3, PWbalde, PHbalde3);
        }else if (botaon == 3){
            batch.draw(baldegema4, PWbalde, PHbalde4);
        }else if (botaon == 2){
            batch.draw(baldegema2, PWbalde, PHbalde2);
        }else{
            batch.draw(baldegema1, PWbalde, PHbalde);
        }

        batch.draw(botao1, 0, 600, botaogema, botaogema);
        batch.draw(botao2, 0, 400, botaogema, botaogema);
        batch.draw(botao3, larguraDispositivo - 100, 600, botaogema, botaogema);
        batch.draw(botao4, larguraDispositivo - 100, 400, botaogema, botaogema);

        batch.draw(controleD, CDW, CDH);
        batch.draw(controleE, CEW, CEH);



    }
    private void drawFormas(){
        controleRD = new Rectangle(
                CDW, CDH,
                244, 239
        );

        controleRE = new Rectangle(
                CEW, CEH,
               244, 239
        );

        botaoR1 = new Rectangle(
                0, 600,
                botaogema, botaogema
        );

        botaoR2 = new Rectangle(
                0, 400,
                botaogema, botaogema
        );

        botaoR3 = new Rectangle(
                larguraDispositivo - 100, 600,
                botaogema, botaogema
        );

        botaoR4 = new Rectangle(
                larguraDispositivo - 100, 400,
                botaogema, botaogema
        );

        gemaR1 = new Rectangle(
                posicaoX1, posicaoY1,
                gema1WSIZE, gema1HSIZE
        );

        gemaR2 = new Rectangle(
                posicaoX2, posicaoY2,
                gema2WSIZE, gema2HSIZE
        );

        gemaR3 = new Rectangle(
                posicaoX3, posicaoY3,
                gema3WSIZE, gema3HSIZE
        );

        gemaR4 = new Rectangle(
                posicaoX4, posicaoY4,
                gema4WSIZE, gema4HSIZE
        );

        badegemaR1 = new Rectangle(
                posicaoXM1, posicaoYM1,
                236, 238
        );

        badegemaR2 = new Rectangle(
                posicaoXM2, posicaoYM2,
                236, 238
        );

        badegemaR3 = new Rectangle(
                posicaoXM3, posicaoYM3,
                236, 238
        );

        badegemaR4 = new Rectangle(
                posicaoXM4, posicaoYM4,
                236, 238
        );
        baldegemaR1 = new Rectangle(
                PWbalde, PHbalde,
                125, 158
        );
        baldegemaR2 = new Rectangle(
                PWbalde, PHbalde2,
                125, 158
        );
        baldegemaR3 = new Rectangle(
                PWbalde, PHbalde3,
                125, 158
        );
        baldegemaR4 = new Rectangle(
                PWbalde, PHbalde4,
                125, 158
        );





    }
    private void checcolision(){
        //Teste de colisão

    }

    private void mudarBalde(Viewport viewport){
        if (Gdx.input.isTouched()) {
            touch.x = Gdx.input.getX();
            touch.y = Gdx.input.getY();
            viewport.unproject(touch);
        }

        if (botaoR1.contains(touch)) {
            PHbalde = 240;
            PHbalde2 = -300;
            PHbalde3 = -300;
            PHbalde4 = -300;
            botaon = 1;

        }else if (botaoR2.contains(touch)){
            PHbalde2 = 240;
            PHbalde = -300;
            PHbalde3 = -300;
            PHbalde4 = -300;
            botaon = 2;

        } else if (botaoR3.contains(touch)){
            PHbalde4 = 240;
            PHbalde2 = -300;
            PHbalde3 = -300;
            PHbalde = -300;
            botaon = 3;

        } else if (botaoR4.contains(touch)){
            PHbalde3 = 240;
            PHbalde2 = -300;
            PHbalde4 = -300;
            PHbalde = -300;
            botaon = 4;

        }

    }



    private void moverbalde(Viewport viewport, float delta){
        for (int i=0; i<5; i++){
            if (!Gdx.input.isTouched(i)) continue;
            viewport.unproject(touchControl.set(Gdx.input.getX(i), Gdx.input.getY(i)));
            if (controleRE.contains(touchControl.x, touchControl.y)){
                //Move your player to the left!
                PWbalde += delta * 400;
            }else if (controleRD.contains(touchControl.x, touchControl.y)){
                //Move your player to the right!
                PWbalde -= delta * 400;
            }
        }

    }

    private void atirar(Viewport viewport){
        atirando = false;
        for (int i=0; i<5; i++){
            if (!Gdx.input.isTouched(i)) continue;
            viewport.unproject(touchTiro.set(Gdx.input.getX(i), Gdx.input.getY(i)));
            if (baldegemaR1.contains(touchControl.x, touchControl.y)){
                //Move your player to the left!
                atirando = true;
            }
        }

    }

    private void retsoma(){

        if (Intersector.overlaps(baldegemaR1, gemaR1)){
            qbalde1 = qbalde1 + 1;
            posicaoY1 = numeroRandomico.nextInt(1300) + (1100);
            listener.hitCoin();

        }else if (Intersector.overlaps(baldegemaR2, gemaR2)){
            qbalde2 = qbalde2 + 1;
            posicaoY2 = numeroRandomico.nextInt(1500) + (1300);
            listener.hitCoin();

        }else if (Intersector.overlaps(baldegemaR3, gemaR3)){
            qbalde4 = qbalde4 + 1;
            posicaoY3 = numeroRandomico.nextInt(1600) + (1500);
            listener.hitCoin();

        }else if (Intersector.overlaps(baldegemaR4, gemaR4)){
            qbalde3 = qbalde3 + 1;
            posicaoY4 = numeroRandomico.nextInt(2000) + (1600);
            listener.hitCoin();


        }
    }


    private void atualizarTiros(float delta) {
        jogador = new Image(baldegema1);
        jogador.setPosition(PWbalde, 240);
        cenario.addActor(jogador);
        cenario.act(delta);
        cenario.draw();

        for (Image tiro : tiros1) {
            // movimenta o tiro em direÃ§Ã£o ao topo da tela
            float x = tiro.getX();
            float y = tiro.getY() + velocidadeTiro * delta;
            tiro.setPosition(x, y);
            // verifica se o tiro jÃ¡ saiu da tela
            if (tiro.getY() > camera.viewportHeight) {
                tiro.remove();
                tiros1.removeValue(tiro, true);
            }
        }

        // cria novos tiros se necessÃ¡rio
        if (atirando) {
            // verifica se o Ãºltimo tiro foi disparado a 400 milisegundos atrÃ¡s
            if (System.currentTimeMillis() - ultimoTiro >= intervaloTiros) {
                Image tiro = new Image(gema1);
                float x = jogador.getX() + jogador.getWidth() / 2 - tiro.getWidth() / 2;
                float y = jogador.getY() + jogador.getHeight();
                tiro.setPosition(x, y);
                tiros1.add(tiro);
                cenario.addActor(tiro);
                ultimoTiro = System.currentTimeMillis();
                listener.jump();
            }
        }
    }


    private long ultimoTiro = 0;





}