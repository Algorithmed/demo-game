package com.entropiat.unicorns.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.entropiat.unicorns.render.IRenderable;
import com.entropiat.unicorns.render.UnAnimation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class LevelTile implements IRenderable {

    @NonNull
    private final Tile tile;
    private int x;
    private int y;
    private UnAnimation animation;

    @Override
    public void draw(SpriteBatch batch, int x, int y, float deltaTime) {
        animation.draw(batch,x,y,deltaTime);
    }
}
