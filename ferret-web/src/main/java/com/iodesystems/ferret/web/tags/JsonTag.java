package com.iodesystems.ferret.web.tags;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTag {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static String encode(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
