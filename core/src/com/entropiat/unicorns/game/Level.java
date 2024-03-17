package com.entropiat.unicorns.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.entropiat.unicorns.render.IRenderable;

public class Level implements IRenderable {
    private int width;
    private int height;
    private int tileSize;
    private LevelTile[][] tiles;

    public Level(int width, int height, int tileSize, LevelTile[][] tiles) {
        this.width = width;
        this.height = height;
        this.tileSize = tileSize;
        this.tiles = tiles;
    }

    @Override
    public void draw(SpriteBatch batch, int x, int y, float deltaTime) {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                LevelTile tile = tiles[i][j];
                tile.draw(batch, x + i * tileSize, y + j* tileSize, deltaTime);
            }
        }
    }
}
