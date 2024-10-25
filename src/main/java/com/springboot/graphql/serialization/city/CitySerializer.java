package com.springboot.graphql.serialization.city;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.springboot.graphql.model.City;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class CitySerializer extends JsonSerializer<City> {
    @Override
    public void serialize(City city, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipStream = new GZIPOutputStream(byteStream)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(gzipStream, city);
        }
        jsonGenerator.writeBinary(byteStream.toByteArray());
    }
}
