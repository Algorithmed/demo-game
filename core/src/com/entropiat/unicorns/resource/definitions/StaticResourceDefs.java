package com.entropiat.unicorns.resource.definitions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaticResourceDefs {
    private Map<String, AnimationDef> animations;
    private Map<String, TileDef> tiles;

}

