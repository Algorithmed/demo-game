package com.entropiat.unicorns.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameResources {
    public Map<String, Animation<TextureRegion>> animations;
    public Map<String, Tile> tileSet;
    public Map<String, Level> levels;
}
