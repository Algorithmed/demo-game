package com.entropiat.unicorns.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IRenderable {

    void  draw(SpriteBatch batch, int x, int y, float deltaTime);
}
