package com.entropiat.unicorns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Animal {

    public Texture getImage() {
        return image;
    }

    private final Texture image;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    private float x = 0;
    private float y = 0;

    private float speed = 100;
    private boolean leftMove;
    private boolean rightMove;

    private boolean upMove;
    private boolean downMove;

    public Animal(Texture image) {
        this.image = image;
    }

    void updateMotion()
    {
        if (leftMove)
        {
            x -= speed * Gdx.graphics.getDeltaTime();
        }
        if (rightMove)
        {
            x += speed * Gdx.graphics.getDeltaTime();
        }

        if (downMove)
        {
            y -= speed * Gdx.graphics.getDeltaTime();
        }
        if (upMove)
        {
            y += speed * Gdx.graphics.getDeltaTime();
        }
    }
    public void setLeftMove(boolean t)
    {
        if(rightMove && t) rightMove = false;
        leftMove = t;
    }
    public void setRightMove(boolean t)
    {
        if(leftMove && t) leftMove = false;
        rightMove = t;
    }

    public void setUpMove(boolean t)
    {
        if(downMove && t) downMove = false;
        upMove = t;
    }
    public void setDownMove(boolean t)
    {
        if(upMove && t) upMove = false;
        downMove = t;
    }
}
