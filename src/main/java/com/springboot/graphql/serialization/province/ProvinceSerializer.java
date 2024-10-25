package com.springboot.graphql.serialization.province;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.springboot.graphql.model.Province;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class ProvinceSerializer extends JsonSerializer<Province> {
    @Override
    public void serialize(Province province, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipStream = new GZIPOutputStream(byteStream)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(gzipStream, province);
        }
        jsonGenerator.writeBinary(byteStream.toByteArray());
    }
}
