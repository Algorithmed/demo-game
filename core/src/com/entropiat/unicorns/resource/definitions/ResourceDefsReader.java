package com.entropiat.unicorns.resource.definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@NoArgsConstructor
public class ResourceDefsReader {
    public ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public ResourceDefs read() throws IOException {
        StaticResourceDefs staticResourceDefs = mapper.readValue(new File("definitions/static-resources.yaml"), StaticResourceDefs.class);
        MutableResourceDefs mutableResourceDefs = mapper.readValue(new File("definitions/mutable-resources.yaml"), MutableResourceDefs.class);
        return new ResourceDefs(staticResourceDefs, mutableResourceDefs);
    }
}
