package com.entropiat.unicorns.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.entropiat.unicorns.render.UnAnimation;
import lombok.Data;
import lombok.NonNull;

import java.util.Random;

public class TextureLoader {
    private final TextureAtlas atlas;

    public TextureLoader(@NonNull String atlasPath) {
        atlas = new TextureAtlas(Gdx.files.internal(atlasPath));
    }

    public Animation<TextureRegion> loadRaw(String name, float frequency) {
        return new Animation<TextureRegion>(frequency, atlas.findRegions(name));
    }

    public UnAnimation load(String name, float frequency, boolean randomStart) {
        Animation<TextureRegion> animation = new Animation<TextureRegion>(frequency, atlas.findRegions(name));
        float startTime = randomStart ? (new Random()).nextFloat() * frequency : 0.0f;
        return new UnAnimation(animation, startTime);
    }
}
