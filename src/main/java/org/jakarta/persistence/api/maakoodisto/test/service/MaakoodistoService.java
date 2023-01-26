package org.jakarta.persistence.api.maakoodisto.test.service;

import org.jakarta.persistence.api.maakoodisto.test.models.Maakoodisto;

import java.util.List;

public interface MaakoodistoService {

    Maakoodisto findMaakoodistoById(Maakoodisto maakoodisto);
    void persistOrMergeMaakoodistotToMySQL(List<Maakoodisto> maakoodistot);
}
