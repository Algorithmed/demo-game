package com.entropiat.unicorns.resource.definitions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelDef {
    private List<LevelTileDef> tiles;
    private int height;
    private int width;
}
