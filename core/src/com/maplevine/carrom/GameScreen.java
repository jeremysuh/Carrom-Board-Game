package com.maplevine.carrom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;


public class GameScreen implements InputProcessor, Screen {

    Carrom game;
    Texture img;
    Sprite background, board, boardBorders;
    SpriteBatch batch;
    OrthographicCamera camera;
    Viewport viewport;

    Piece w1,w2,w3,w4,w5;
    Piece b1,b2,b3,b4,b5;


    ArrayList<Piece> whitePieceContainer;
    ArrayList<Piece> brownPieceContainer;

    int temp = 30;




    int timer = 128;
    float a = 0;

    public GameScreen(Carrom carrom, SpriteBatch batch, OrthographicCamera camera,  Viewport viewport) {



        this.game = carrom;
        this.batch = batch;
        this.camera = camera;
        this.viewport = viewport;

        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        viewport = new StretchViewport(800, 600, camera);
        viewport.apply();

        background = new Sprite(ResourceManager.gameBackground);
        background.setSize(800,600);
        background.setPosition(0,0);

        board = new Sprite(ResourceManager.carromBoard);
        board.setSize(500,500);
        board.setPosition(400-250, 300-250);

        boardBorders = new Sprite(ResourceManager.carromBoardBorders);
        boardBorders.setSize(550,550);
        boardBorders.setPosition(400-275, 300-276);

        w1 = new Piece(0,300,250);
        w2 = new Piece(0,300,230);
        w3 = new Piece(0,300,150);
        w4 = new Piece(0,300,270);
        w5 = new Piece(0,300,250);

        whitePieceContainer = new ArrayList<Piece>();

        whitePieceContainer.add(w1);
        whitePieceContainer.add(w2);
        whitePieceContainer.add(w3);
        whitePieceContainer.add(w4);
        whitePieceContainer.add(w5);

        b1 = new Piece(1,300,250);
        b2 = new Piece(1,300,230);
        b3 = new Piece(1,300,150);
        b4 = new Piece(1,300,270);
        b5 = new Piece(1,300,250);

        brownPieceContainer = new ArrayList<Piece>();

        brownPieceContainer.add(b1);
        brownPieceContainer.add(b2);
        brownPieceContainer.add(b3);
        brownPieceContainer.add(b4);
        brownPieceContainer.add(b5);



        ResourceManager.create();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        camera.update();
        batch.setProjectionMatrix(camera.combined);



        batch.begin();


        temp--;
        if (temp <= 0){
            temp = 90;
            touchDown(1,1,1,1);
        }


        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1,1,1,1);

        background.draw(batch);
        boardBorders.draw(batch);
        board.draw(batch);

        updatePieces();

        //board = new Sprite(ResourceManager.carromBoard);
        board.setSize(500,500);
        board.setPosition(400-250, 300-250);

       // boardBorders = new Sprite(ResourceManager.carromBoardBorders);
        boardBorders.setSize(550,550);
        boardBorders.setPosition(400-275, 300-276);




        batch.end();



    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

    }

    public void updatePieces(){

        for (Piece w: whitePieceContainer){


            if (w.x <= 150-5){
                w.x = 150-5;
                w.speedX *= -1;
            }

            if (w.x >= 150+500+5-30){

                w.x = 150+500+5-30;
                w.speedX *= -1;
            }
            if (w.y <= 50-5){

                w.y = 50-5;
                w.speedY *= -1;

            }
            if (w.y >= 50+500+5-30){
                w.y = 50+500+5-30;
                w.speedY *= -1;
            }

            w.draw(batch);


        }

        for (Piece w: brownPieceContainer){



            if (w.x <= 150-5){
                w.x = 150-5;
                w.speedX *= -1;
            }

            if (w.x >= 150+500+5-30){

                w.x = 150+500+5-30;
                w.speedX *= -1;
            }
            if (w.y <= 50-5){

                w.y = 50-5;
                w.speedY *= -1;

            }
            if (w.y >= 50+500+5-30){
                w.y = 50+500+5-30;
                w.speedY *= -1;
            }

            w.draw(batch);


        }


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        for (Piece w: whitePieceContainer) {

            w.speedX = (float)Math.random()*24-12;
            w.speedY = (float)Math.random()*24-12;

        }

        for (Piece w: brownPieceContainer) {

            w.speedX = (float)Math.random()*24-12;
            w.speedY = (float)Math.random()*24-12;

        }
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
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}