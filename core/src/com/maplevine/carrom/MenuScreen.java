package com.maplevine.carrom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

public class MenuScreen implements InputProcessor, Screen{

    Carrom game;
    SpriteBatch batch;
    OrthographicCamera camera;
    Viewport viewport;

    Sprite background;
    Button onePlayer, twoPlayer;
    float sW, sH;

    ArrayList<Button> buttonContainer;


    public MenuScreen(Carrom carrom, SpriteBatch batch) {




        this.game = carrom;
        this.batch = batch;
        this.camera = camera;
        this.viewport = viewport;

        camera = new OrthographicCamera();

        buttonContainer = new ArrayList<Button>();

         viewport = new StretchViewport(800,600,camera);
        viewport.apply();
        Gdx.input.setInputProcessor(this);

        background = new Sprite(ResourceManager.menuBackground);
        background.setSize(800,600);
        background.setPosition(0,0);

        onePlayer = new Button(ResourceManager.onePlayer,400-75-100,225,150,150);
        buttonContainer.add(onePlayer);
        twoPlayer = new Button(ResourceManager.twoPlayer,400-75+115,225,150,150);
        buttonContainer.add(twoPlayer);


        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);



    }


    @Override
    public void render(float delta) {

        camera.update();



        batch.begin();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       Gdx.gl.glClearColor(1,1,1,1);

         background.draw(batch);

        for (Button b: buttonContainer){
            b.draw(batch);
        }



        batch.setProjectionMatrix(camera.combined);

        batch.end();


    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);


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



        Vector3 touchPosition = new Vector3(screenX, screenY, 0);
        camera.unproject(touchPosition);
        Rectangle touch = new Rectangle(touchPosition.x-8, touchPosition.y-8,16,16);

        for (Button b: buttonContainer) {

            if (touch.overlaps(b.hitPoint)) {

                if (b.equals(onePlayer)) {
                    onePlayer.press();

                }
                if (b.equals(twoPlayer)) {
                    twoPlayer.press();

                }
            }
        }



        return false;


    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        Vector3 touchPosition = new Vector3(screenX, screenY, 0);
        camera.unproject(touchPosition);
        Rectangle touch = new Rectangle(touchPosition.x-8, touchPosition.y-8,16,16);

        System.out.println("huh");

        for (Button b: buttonContainer){
            b.release();

            if (b.equals(onePlayer) && onePlayer.isPressed() && pointer == 0){

                game.setScreen(new GameScreen(game, batch, camera, viewport));
            }
        }




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

    @Override
    public void show() {

    }
}
