package com.springboot.graphql.serialization.province;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.io.ByteArrayInputStream;

import com.springboot.graphql.model.Province;

public class ProvinceDeserializer extends JsonDeserializer<Province> {
    @Override
    public Province deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        byte[] compressedData = jsonParser.getBinaryValue();
        try (GZIPInputStream gzipStream = new GZIPInputStream(new ByteArrayInputStream(compressedData))) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(gzipStream, Province.class);
        }
    }
}
