package org.jakarta.persistence.api.maakoodisto.test.service;

import org.jakarta.persistence.api.maakoodisto.test.models.Maakoodisto;
import jakarta.persistence.*;
import org.jakarta.persistence.api.maakoodisto.test.utils.CreateUpdateMaakoodistot;

import java.util.List;
import java.util.logging.Logger;

public class MaakoodistoServiceImpl implements MaakoodistoService {

    private static final Logger LOGGER = Logger.getLogger("logger");
    private EntityManager entityManager = createEntityManager("hibernate-maakoodisto");

    @Override
    public Maakoodisto findMaakoodistoById(Maakoodisto maakoodisto) {
        return entityManager.find(Maakoodisto.class, maakoodisto.getCode());
    }

    @Override
    public void persistOrMergeMaakoodistotToMySQL(List<Maakoodisto> maakoodistot) {
        entityManager.getTransaction().begin();

        for (Maakoodisto maakoodisto : maakoodistot) {

            Maakoodisto foundMaakoodisto = findMaakoodistoById(maakoodisto);

            if (foundMaakoodisto == null) {
                entityManager.persist(maakoodisto);
                LOGGER.info("Maakoodisto Persisted!");
            } else {
                Maakoodisto updatedMaakoodisto = CreateUpdateMaakoodistot.updateMaakoodisto(maakoodisto, foundMaakoodisto);
                entityManager.merge(updatedMaakoodisto);
                LOGGER.info("Maakoodisto Merged!");
            }
        }

        logMaakoodisto(entityManager);

        entityManager.getTransaction().commit();

        closeEntityManagerFactory(entityManager);
    }

    private static void logMaakoodisto(EntityManager entityManager) {

        List<Maakoodisto> foundMaakoodistot = entityManager
                .createNamedQuery("Maakoodisto.findAll", Maakoodisto.class)
                .getResultList();

        LOGGER.info(foundMaakoodistot.toString());

    }

    private static EntityManager createEntityManager(String persistenceUnitName) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);

         return emf.createEntityManager();
    }

    private static void closeEntityManagerFactory(EntityManager entityManager) {
         EntityManagerFactory emf = entityManager.getEntityManagerFactory();

         LOGGER.info("EntityManagerFactory Closed!");

         emf.close();
    }
}
