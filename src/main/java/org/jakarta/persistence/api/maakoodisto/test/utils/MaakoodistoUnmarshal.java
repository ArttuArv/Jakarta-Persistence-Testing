package org.jakarta.persistence.api.maakoodisto.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jakarta.persistence.api.maakoodisto.test.models.Maakoodisto;

public class MaakoodistoUnmarshal {

    static ObjectMapper mapper = new ObjectMapper();

    public static Maakoodisto unmarshalMaakoodistoJsonStringToMaakoodistoObject(String maakoodistoJson) {
        try {
            return mapper.readValue(maakoodistoJson, Maakoodisto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }





}
