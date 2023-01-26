package org.jakarta.persistence.api.maakoodisto.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.jakarta.persistence.api.maakoodisto.test.models.Maakoodisto;

import java.util.Arrays;
import java.util.List;

public class MaakoodistoUnmarshal {

    static ObjectMapper mapper = new ObjectMapper();

    public static Maakoodisto unmarshalSingleMaakoodistoJsonToMaakoodistoObject(String maakoodistoJson) {
        try {
            return mapper.readValue(maakoodistoJson, Maakoodisto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Maakoodisto> unmarshalArrayOfMaakoodistot(String maakoodistoJson) {
        try {
            return mapper.readerForListOf(Maakoodisto.class).readValue(maakoodistoJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }





}
