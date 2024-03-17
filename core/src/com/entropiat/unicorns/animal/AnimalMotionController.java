package com.entropiat.unicorns.animal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.entropiat.unicorns.Position;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnimalMotionController {
    private boolean leftMove;
    private boolean rightMove;

    private boolean upMove;
    private boolean downMove;

    void updateMotion(Position position, float speed, float deltaTime)
    {
        if (leftMove)
        {
            position.setX(position.getX() - speed * deltaTime);
        }
        if (rightMove)
        {
            position.setX(position.getX() + speed * deltaTime);
        }

        if (downMove)
        {
            position.setY(position.getY() - speed * deltaTime);
        }
        if (upMove)
        {
            position.setY(position.getY() + speed * deltaTime);
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
