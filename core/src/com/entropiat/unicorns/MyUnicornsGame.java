package com.entropiat.unicorns;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.entropiat.unicorns.inputhandler.MyInputProcessor;

public class MyUnicornsGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Music tutuMusic;
	private OrthographicCamera camera;
	private MyInputProcessor inputProcessor;

	private Animal animal;

	private Texture grass;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		grass = new Texture("images/grass.png");

		tutuMusic = Gdx.audio.newMusic(Gdx.files.internal("music/background-music.mp3"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1600, 960);

		animal = new Animal(new Texture("images/goat.png"));
		inputProcessor = new MyInputProcessor(animal, Gdx.audio.newSound(Gdx.files.internal("music/me.mp3")));
		Gdx.input.setInputProcessor(inputProcessor);

		tutuMusic.setLooping(true);
		tutuMusic.play();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		batch.draw(grass, 0, 0);
		animal.updateMotion();
		batch.draw(animal.getImage(), animal.getX(), animal.getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		grass.dispose();
		animal.getImage().dispose();
		tutuMusic.dispose();
	}
}
