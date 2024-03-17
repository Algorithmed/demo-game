package com.entropiat.unicorns.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.entropiat.unicorns.render.IRenderable;
import com.entropiat.unicorns.render.UnAnimation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class Tile {
    @NonNull
    private final Animation<TextureRegion> animation;
}
