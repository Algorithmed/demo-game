package com.entropiat.unicorns.resource.definitions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MutableResourceDefs {
    private Map<String, LevelDef> levels;
}
