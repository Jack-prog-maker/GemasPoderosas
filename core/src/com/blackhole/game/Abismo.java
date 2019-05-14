package com.blackhole.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.security.Key;
import java.util.Random;

import javax.swing.text.View;

import sun.rmi.runtime.Log;

public class Abismo extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture[] passaros;
    private Texture fundoA;
    private Texture fundoB;
    private Texture fundoC;
    private Texture fundoD;
    private Texture fundoE;
    private Texture fundoF;
    private Texture fundoG;
    private Texture fundoH;
    private Texture fundoI;
    private Texture fundoJ;
    private Texture fundoK;
    private Texture fundoL;
    private Texture fundoM;

    private Texture canoBaixo;
    private Texture canoTopo;
    private Texture gameOver;
    private Random numeroRandomico;
    private BitmapFont fonte;
    private BitmapFont mensagem;
    private BitmapFont gravidtexto;
    private Circle passaroCirculo;
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


    //Atributos de configuracao
    private float larguraDispositivo;
    private float alturaDispositivo;
    private int estadoJogo=0;// 0-> jogo não iniciado 1-> jogo iniciado 2-> Game Over
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

    private float vel = 400;
    private float scorecont = 70;

    //Câmera
    private OrthographicCamera camera;
    private Viewport viewport;
    private final float VIRTUAL_WIDTH = 768;
    private final float VIRTUAL_HEIGHT = 1024;

    public AdService adService;

    public Abismo(AdService adService){
        this.adService=adService;
    }


    @Override
    public void create () {

        batch = new SpriteBatch();
        numeroRandomico = new Random();
        passaroCirculo = new Circle();
        fonte = new BitmapFont();
        fonte.setColor(Color.LIGHT_GRAY);
        fonte.getData().setScale(6);

        gravidtexto = new BitmapFont();
        gravidtexto.setColor(Color.LIGHT_GRAY);
        gravidtexto.getData().setScale(4);

        mensagem = new BitmapFont();
        mensagem.setColor(Color.BLUE);
        mensagem.getData().setScale(3);


        passaros = new Texture[5];
        passaros[0] = new Texture("Estrela.png");
        passaros[1] = new Texture("estrela2.png");
        passaros[2] = new Texture("estrela3.png");
        passaros[3] = new Texture("estrela4.png");
        passaros[4] = new Texture("estrela5.png");


        fundoA = new Texture("espacoA.jpg");
        fundoB = new Texture("espacoB.jpg");
        fundoC = new Texture("espacoC.jpg");
        fundoD = new Texture("espacoD.jpg");
        fundoE = new Texture("espacoE.jpg");
        fundoF = new Texture("espacoF.jpg");
        fundoG = new Texture("espacoG.jpg");
        fundoH = new Texture("espacoH.jpg");
        fundoI = new Texture("espaco.jpg");
        fundoJ = new Texture("espacoJ.jpg");
        fundoK = new Texture("espacoK.jpg");
        fundoL = new Texture("espacoL.jpg");
        fundoM = new Texture("espacoM.jpg");




        canoBaixo = new Texture("dimensaoE.PNG");
        canoTopo = new Texture("dimensaoD.PNG");
        gameOver = new Texture("gameover.png");

        /**********************************************
         * Configuração da câmera
        * */
        camera = new OrthographicCamera();
        camera.position.set(VIRTUAL_WIDTH/2,VIRTUAL_HEIGHT/2, 0);
        viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

        larguraDispositivo = VIRTUAL_WIDTH;
        alturaDispositivo  = VIRTUAL_HEIGHT;


        posicaoI = -50;
        posicao1 = -500;
        posicao2 = -1000;
        mpass  = new Vector3(Gdx.graphics.getWidth() / 2, 0, 0);


        espacoEntreCanos = 300;



    }

    @Override
    public void render () {

        camera.update();

        // Limpar frames anteriores
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        deltaTime = Gdx.graphics.getDeltaTime();
        variacao += deltaTime * 10;
        if (variacao > 2) variacao = 0;

        if( estadoJogo == 0 ){//Não iniciado

            if( Gdx.input.justTouched() ){
                estadoJogo = 1;

            }

        }else {//Iniciado

            if( Gdx.input.isTouched() ){
                mpass.set(Gdx.input.getX(), 650, 0);
            }



            if( estadoJogo == 1 ){//iniciado
                pontuacao += deltaTime * scorecont;
                pontuacao2 += deltaTime * scorecont;
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
                    if (vel > 1000){
                        vel = vel + 3;
                    }else if (vel > 650){
                        vel = vel + 20;
                    }else {
                        vel = vel + 80;
                    }

                }




            }else  if (estadoJogo == 3){
                estadoJogo = 0;
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
            } else{// Game Over
                //Zerar o valores padrões
                if( Gdx.input.justTouched() ){
                    estadoJogo = 0;
                    pontuacao = 0;
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

                }

            }


        }

        //Configurar dados de projeção da câmera
        batch.setProjectionMatrix( camera.combined );

        batch.begin();
        if (pontuacao > 25000){
            batch.draw(fundoM, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 23000){
            batch.draw(fundoL, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 22000){
            batch.draw(fundoK, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 20500){
            batch.draw(fundoJ, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 16000){
            batch.draw(fundoI, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 14000){
            batch.draw(fundoH, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 13000){
            batch.draw(fundoG, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 11100){
            batch.draw(fundoF, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 10000){
            batch.draw(fundoE, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 8000){
            batch.draw(fundoD, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 6000){
            batch.draw(fundoC, 0, 0, larguraDispositivo, alturaDispositivo);

        }else if (pontuacao > 3000){
            batch.draw(fundoB, 0, 0, larguraDispositivo, alturaDispositivo);

        }else{
            batch.draw(fundoA, 0, 0, larguraDispositivo, alturaDispositivo);

        }


        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao2);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao2);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao3);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao3);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao4);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao4);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao5);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao5);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao6);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao6);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao7);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao7);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao8);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao8);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao9);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao9);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao10);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao10);

        batch.draw(canoTopo, larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI);
        batch.draw(canoBaixo, larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI);

        String fs = "HI - " + highscore + "  " + pontuacao;
        String fp = "" + pontuacao;
        if (highscore == 0){
            gravidtexto.draw(batch, fp, larguraDispositivo / 2 - 350, alturaDispositivo - 50);
        }else{
            gravidtexto.draw(batch, fs, larguraDispositivo / 2 - 350, alturaDispositivo - 50);
        }

        batch.draw(passaros[(int) variacao], mpass.x, 650);
        if( estadoJogo == 2 ) {
            mensagem.draw(batch, "Toque para reiniciar!", larguraDispositivo / 2 - 230, alturaDispositivo / 2 - gameOver.getHeight());
            batch.draw(gameOver, larguraDispositivo / 2 - gameOver.getWidth() / 2, alturaDispositivo / 2);
             if (highscore < pontuacao){
                highscore = pontuacao;
            }


        }
        batch.end();

        passaroCirculo.set(mpass.x  + passaros[0].getWidth() / 2, 650 + passaros[0].getHeight() / 2, 30);


        retanguloCanoBaixoI = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoTopoI = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica0, posicaoI,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo1 = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo1 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica1, posicao1,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo2 = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao2,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo2 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica2, posicao2,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo3 = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao3,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo3 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica3, posicao3,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo4 = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao4,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo4 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica4, posicao4,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo5 = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao5,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo5 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica5, posicao5,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo6= new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao6,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo6 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica6, posicao6,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo7 = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao7,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo7 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica7, posicao7,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo8 = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao8,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo8 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica8, posicao8,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo9 = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao9,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo9 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica9, posicao9,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        retanguloCanoBaixo10 = new Rectangle(
                larguraDispositivo / 2 - canoBaixo.getWidth() - espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao10,
                canoBaixo.getWidth(), canoBaixo.getHeight()
        );

        retanguloCanoTopo10 = new Rectangle(
                larguraDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica10, posicao10,
                canoTopo.getWidth(), canoTopo.getHeight()
        );

        //Teste de colisão
         if( Intersector.overlaps( passaroCirculo, retanguloCanoBaixoI ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopoI)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo1 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo1)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo2 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo2)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo3 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo3)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo4 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo4)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo5 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo5)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo6 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo6)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo7 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo7)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo8 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo8)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo9 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo9)
                 || ( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo10 ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo10)))))))))))){
            //Gdx.app.log("Colisão", "Houve colisão");
             adService.showOrLoadInterstitial();
             estadoJogo = 2;


         }

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }







}
