package com.entropiat.unicorns.resource.definitions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelTileDef {
    private int x;
    private int y;
    private String name;
}
