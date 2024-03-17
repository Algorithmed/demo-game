package com.entropiat.unicorns.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class UnAnimation implements IRenderable {

    @NonNull
    private Animation<TextureRegion> animation;

    private float stateTime = 0.0f;
    @Override
    public void draw(SpriteBatch batch, int x, int y, float deltaTime) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, x, y);
    }
}
