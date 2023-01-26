package org.jakarta.persistence.api.maakoodisto.test;

import org.jakarta.persistence.api.maakoodisto.test.models.*;
import org.jakarta.persistence.api.maakoodisto.test.service.*;
import org.jakarta.persistence.api.maakoodisto.test.utils.*;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final String MAAKOODISTO2UPDATE = FileReadingUtils.readFileAsStringFromResources("maakoodistoJSON/maakoodisto2Update.json");
    private static final String MAAKOODISTO_ARRAY = FileReadingUtils.readFileAsStringFromResources("maakoodistoJSON/maakoodistoArray.json");
    
    private static final Logger LOGGER = Logger.getLogger("logger");

    private static final MaakoodistoService MAAKOODISTO_SERVICE = new MaakoodistoServiceImpl();

    public static void main(String[] args) {

        List<Maakoodisto> maakoodistot = createMaakoodistot();

        MAAKOODISTO_SERVICE.persistOrMergeMaakoodistotToMySQL(maakoodistot);

    }

    /**
     * Creates Maakoodisto objects from JSON file. 
     * Add one more Maakoodisto object to the list.
     * File contains 249 Maakoodisto objects.
     * 
     * @return List of Maakoodisto objects
     */
    private static List<Maakoodisto> createMaakoodistot() {

        List<Maakoodisto> maakoodistot = MaakoodistoUnmarshal.unmarshalArrayOfMaakoodistot(MAAKOODISTO_ARRAY);

        // Updated Maakoodisto object
        maakoodistot.add(MaakoodistoUnmarshal.unmarshalSingleMaakoodistoJsonToMaakoodistoObject(MAAKOODISTO2UPDATE));

        return maakoodistot;
    }
}