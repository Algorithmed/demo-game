package com.entropiat.unicorns.inputhandler;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.entropiat.unicorns.Animal;

public class MyInputProcessor implements InputProcessor {

    private final Animal animal;

    private final Sound meSound;

    public MyInputProcessor(Animal animal, Sound meSound) {
        this.animal = animal;
        this.meSound = meSound;
    }

    @Override
    public boolean keyDown(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                animal.setLeftMove(true);
                break;
            case Input.Keys.RIGHT:
                animal.setRightMove(true);
                break;
            case Input.Keys.UP:
                animal.setUpMove(true);
                break;
            case Input.Keys.DOWN:
                animal.setDownMove(true);
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
                animal.setLeftMove(false);
                break;
            case Input.Keys.RIGHT:
                animal.setRightMove(false);
                break;
            case Input.Keys.UP:
                animal.setUpMove(false);
                break;
            case Input.Keys.DOWN:
                animal.setDownMove(false);
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

    public boolean touchDown (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        return false;
    }

    public boolean scrolled (float amountX, float amountY) {
        return false;
    }
}
