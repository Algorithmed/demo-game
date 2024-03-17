package com.entropiat.unicorns.resource;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.entropiat.unicorns.game.GameResources;
import com.entropiat.unicorns.game.Level;
import com.entropiat.unicorns.game.LevelTile;
import com.entropiat.unicorns.game.Tile;
import com.entropiat.unicorns.render.UnAnimation;
import com.entropiat.unicorns.resource.definitions.*;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ResourceLoader {

    @NonNull
    private TextureLoader textureLoader;


    public GameResources buildResources(ResourceDefs resourceDefs) {
        GameResources gameResources = new GameResources();
        gameResources.setAnimations(buildAnimations(resourceDefs.getStaticResource().getAnimations()));
        gameResources.setTileSet(buildTileSet(resourceDefs.getStaticResource().getTiles(), gameResources.getAnimations()));
        gameResources.setLevels(buildLevels(resourceDefs.getMutableResource().getLevels(), gameResources.getTileSet()));
        return gameResources;
    }

    public Map<String, Animation<TextureRegion>>  buildAnimations(Map<String, AnimationDef> animations) {
        return animations.entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey(),
                e -> textureLoader.loadRaw(e.getKey(), e.getValue().getFrequency())
        ));
    }

    public Map<String, Tile>  buildTileSet(Map<String, TileDef> tiles, Map<String, Animation<TextureRegion>> animations) {
        return tiles.entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey(),
                e ->         {
                    Animation<TextureRegion> animation = animations.get(e.getValue().getAnimation());
                    return new Tile(animation);
                }
        )
        );
    }

    public Map<String, Level>  buildLevels(Map<String, LevelDef> levels, Map<String, Tile> tileSet) {
        return levels.entrySet().stream().collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> buildLevel(e.getValue(), tileSet)
                )
        );
    }

    public Level buildLevel(LevelDef level, Map<String, Tile> tileSet) {
        LevelTile[][] tiles = new LevelTile[level.getWidth()][level.getHeight()];
        level.getTiles().forEach(t -> tiles[t.getX()][t.getY()] = buildLevelTile(t, tileSet.get(t.getName())));
        return new Level(level.getWidth(), level.getHeight(), 100, tiles);
    }

    public LevelTile buildLevelTile(LevelTileDef levelTileDef, Tile tile) {
        Animation<TextureRegion> animation = tile.getAnimation();
        float startTime = new Random().nextFloat() * animation.getFrameDuration() * animation.getKeyFrames().length;
        return new LevelTile(tile, levelTileDef.getX(), levelTileDef.getY(), new UnAnimation(animation, startTime));
    }
}
