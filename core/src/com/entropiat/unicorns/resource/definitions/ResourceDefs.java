package com.entropiat.unicorns.resource.definitions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ResourceDefs {
    @NonNull
    private final StaticResourceDefs staticResource;

    @NonNull
    private final MutableResourceDefs mutableResource;
}
