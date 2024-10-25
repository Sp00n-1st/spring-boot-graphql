package com.springboot.graphql.serialization.city;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.io.ByteArrayInputStream;

import com.springboot.graphql.model.City;

public class CityDeserializer extends JsonDeserializer<City> {
    @Override
    public City deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        byte[] compressedData = jsonParser.getBinaryValue();
        try (GZIPInputStream gzipStream = new GZIPInputStream(new ByteArrayInputStream(compressedData))) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(gzipStream, City.class);
        }
    }
}
