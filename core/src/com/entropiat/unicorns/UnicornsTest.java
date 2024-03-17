package com.entropiat.unicorns;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.entropiat.unicorns.game.GameResources;
import com.entropiat.unicorns.game.Level;
import com.entropiat.unicorns.resource.ResourceLoader;
import com.entropiat.unicorns.resource.TextureLoader;
import com.entropiat.unicorns.resource.definitions.ResourceDefs;
import com.entropiat.unicorns.resource.definitions.StaticResourceDefs;
import com.entropiat.unicorns.resource.definitions.ResourceDefsReader;

import java.io.IOException;

public class UnicornsTest extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	Animation<TextureRegion> testAnimation;

	TextureAtlas atlas;

	float stateTime;

	private GameResources gameResources;

	private Level level1;
	private Level level2;

	public TextureRegion[] split (Texture texture, int width, int height, int rows, int columns) {
		TextureRegion[] frames = new TextureRegion[rows * columns];

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < columns; ++j ) {
				frames[i*columns + j] = new TextureRegion(texture, j * width, i * height, width, height);
			}
		}

		return frames;
	}
	@Override
	public void create () {
		ResourceLoader resourceLoader = new ResourceLoader(new TextureLoader("images/animation-test/unicorns.atlas"));
		ResourceDefsReader resourceDefsReader = new ResourceDefsReader();

		try {
			ResourceDefs resourceDefs = resourceDefsReader.read();
			gameResources = resourceLoader.buildResources(resourceDefs);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		level1 = gameResources.getLevels().get("hill");


		batch = new SpriteBatch();
//		atlas = new TextureAtlas(Gdx.files.internal("images/animation-test/unicorns.atlas"));
//		atlas.findRegions("romb");
//		atlas.createSprites().toArray();
//
//		testAnimation = new Animation<TextureRegion>(2.0f, atlas.findRegions("romb"));
//		stateTime = 0f;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1600, 960);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		stateTime += Gdx.graphics.getDeltaTime();
//		TextureRegion currentFrame = testAnimation.getKeyFrame(stateTime, true);

		batch.begin();
//		batch.draw(currentFrame, 100, 100);
		level1.draw(batch, 100, 100, stateTime);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
