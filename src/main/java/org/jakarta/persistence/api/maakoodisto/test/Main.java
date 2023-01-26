package org.jakarta.persistence.api.maakoodisto.test;

import org.jakarta.persistence.api.maakoodisto.test.models.*;
import org.jakarta.persistence.api.maakoodisto.test.service.*;
import org.jakarta.persistence.api.maakoodisto.test.utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final String MAAKOODISTO = FileReadingUtils.readFileAsStringFromResources("maakoodistoJSON/maakoodisto.json");
    private static final String MAAKOODISTO2 = FileReadingUtils.readFileAsStringFromResources("maakoodistoJSON/maakoodisto2.json");
    private static final String MAAKOODISTO3 = FileReadingUtils.readFileAsStringFromResources("maakoodistoJSON/maakoodisto3.json");
    private static final String MAAKOODISTO2UPDATE = FileReadingUtils.readFileAsStringFromResources("maakoodistoJSON/maakoodisto2Update.json");
    
    private static final Logger LOGGER = Logger.getLogger("logger");

    private static final MaakoodistoService MAAKOODISTO_SERVICE = new MaakoodistoServiceImpl();

    public static void main(String[] args) {

        List<Maakoodisto> maakoodistot = createMaakoodistot();

        MAAKOODISTO_SERVICE.persistOrMergeMaakoodistotToMySQL(maakoodistot);

    }

    private static List<Maakoodisto> createMaakoodistot() {

        List<Maakoodisto> maakoodistot = new ArrayList<>();
        maakoodistot.add(MaakoodistoUnmarshal.unmarshalMaakoodistoJsonStringToMaakoodistoObject(MAAKOODISTO));
        maakoodistot.add(MaakoodistoUnmarshal.unmarshalMaakoodistoJsonStringToMaakoodistoObject(MAAKOODISTO2));
        maakoodistot.add(MaakoodistoUnmarshal.unmarshalMaakoodistoJsonStringToMaakoodistoObject(MAAKOODISTO3));
        maakoodistot.add(MaakoodistoUnmarshal.unmarshalMaakoodistoJsonStringToMaakoodistoObject(MAAKOODISTO2UPDATE));

        return maakoodistot;
    }
}