package com.entropiat.unicorns.animal;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.entropiat.unicorns.logic.IGameObject;
import com.entropiat.unicorns.render.IRenderable;
import com.entropiat.unicorns.Position;
import lombok.Data;
import lombok.NonNull;

@Data
public class NewAnimal implements IRenderable, IGameObject {

    private float speed;

    @NonNull
    private Position position;

    @NonNull
    private final Texture image;

    @NonNull
    private final AnimalMotionController animalMotionController;

    @NonNull
    private final AnimalInputAdapter animalInputAdapter;
    @Override
    public void tick(float deltaTime) {
        animalMotionController.updateMotion(position, speed, deltaTime);
    }

    @Override
    public void draw(SpriteBatch batch, int x, int y, float deltaTime) {
        batch.draw(image, position.getX(), position.getY());
    }
}
