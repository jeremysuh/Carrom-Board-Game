package com.maplevine.carrom;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


/**
 * Created by jeunghwansuh on 7/10/17.
 */

public class ResourceManager {

    public static Texture
            menuBackground,
            onePlayer,
            twoPlayer,
            carromBoard,
            carromBoardBorders,
            gameBackground,
            red,
            white,
            brown;


    public  static void create(){


        menuBackground = new Texture(Gdx.files.internal("Carrom Background.png"));
        gameBackground = new Texture(Gdx.files.internal("Game Background.png"));
        onePlayer = new Texture(Gdx.files.internal("One Player.png"));
        twoPlayer = new Texture(Gdx.files.internal("Two Player.png"));
        carromBoard = new Texture(Gdx.files.internal("Carrom Board.png"));
        carromBoardBorders = new Texture(Gdx.files.internal("Carrom Board Borders.png"));
        red = new Texture(Gdx.files.internal("Red.png"));
        white = new Texture(Gdx.files.internal("White.png"));
       brown = new Texture(Gdx.files.internal("Brown.png"));
    }
    public static void dispose(){

        menuBackground.dispose();
        gameBackground.dispose();
        onePlayer.dispose();
        twoPlayer.dispose();
        carromBoard.dispose();
        carromBoardBorders.dispose();
        red.dispose();
        white.dispose();
        brown.dispose();



    }

}