package com.maplevine.carrom;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Piece {


     Sprite piece;
    float alpha, width = 30, height = 30,x,y,speedX = 12, speedY = 12, friction = 0.98f;
    public Rectangle hitPoint;




    public Piece(int id, float x, float y){

        piece = new Sprite(ResourceManager.brown);

        if (id == 1){
            piece.setTexture(ResourceManager.white);
        }

        piece.setPosition(x,y);
        piece.setSize(width,height);

        this.x = x;
        this.y = y;


        hitPoint = new Rectangle(x,y,width,height);


    }



    public void draw(SpriteBatch batch){



        speedX*=friction;
        speedY*=friction;
        x+=speedX;
        y+=speedY;

        piece.setPosition(x,y);
        hitPoint.setPosition(x,y);

        piece.draw(batch);



    }









}
