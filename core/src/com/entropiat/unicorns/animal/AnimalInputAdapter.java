package com.entropiat.unicorns.animal;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Sound;
import com.entropiat.unicorns.Animal;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnimalInputAdapter extends InputAdapter {

    @NonNull
    private AnimalMotionController animalMotionController;

    @NonNull
    private Sound meSound;

    @Override
    public boolean keyDown(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                animalMotionController.setLeftMove(true);
                break;
            case Input.Keys.RIGHT:
                animalMotionController.setRightMove(true);
                break;
            case Input.Keys.UP:
                animalMotionController.setUpMove(true);
                break;
            case Input.Keys.DOWN:
                animalMotionController.setDownMove(true);
                break;
        }
        return true;
    }
    @Override
    public boolean keyUp(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                animalMotionController.setLeftMove(false);
                break;
            case Input.Keys.RIGHT:
                animalMotionController.setRightMove(false);
                break;
            case Input.Keys.UP:
                animalMotionController.setUpMove(false);
                break;
            case Input.Keys.DOWN:
                animalMotionController.setDownMove(false);
                break;
        }
        return true;
    }

    public boolean keyTyped (char character) {
        switch (character)
        {
            case 'm':
                meSound.play();
                break;
        }
        return true;
    }
}
