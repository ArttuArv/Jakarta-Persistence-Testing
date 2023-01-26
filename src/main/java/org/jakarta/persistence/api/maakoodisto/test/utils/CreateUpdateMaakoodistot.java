package org.jakarta.persistence.api.maakoodisto.test.utils;

import java.util.*;

import org.jakarta.persistence.api.maakoodisto.test.models.*;

public final class CreateUpdateMaakoodistot {

  private CreateUpdateMaakoodistot() {
    // Private constructor to hide the implicit public one
  }

  /**
   * Creates a list of four Maakoodisto objects
   * 
   * @return List of Maakoodisto objects
   */
  public static List<Maakoodisto> createMaakoodistoList() {
    List<Maakoodisto> maakoodistot = new ArrayList<>();

    maakoodistot.add(createMaakoodisto("004"));
    maakoodistot.add(createMaakoodisto("008"));
    maakoodistot.add(createMaakoodisto("012"));
    maakoodistot.add(createMaakoodisto("004")); // Already existing ID

    return maakoodistot;
  }

  /**
   * Updates Maakoodisto object with different values
   * 
   * @param maakoodistoToBeUpdated Maakoodisto object to be updated from database
   * @return Maakoodisto object with updated values
   */
  public static Maakoodisto updateMaakoodisto(Maakoodisto maakoodistoToBeMerged, Maakoodisto maakoodistoToBeUpdated) {

    maakoodistoToBeUpdated.setClassification(
            updateClassification(maakoodistoToBeMerged.getClassification(),
                    maakoodistoToBeUpdated.getClassification()));
    maakoodistoToBeUpdated.setLocalId(maakoodistoToBeMerged.getLocalId());
    maakoodistoToBeUpdated.setLevel(maakoodistoToBeMerged.getLevel());
    maakoodistoToBeUpdated.setOrder(maakoodistoToBeMerged.getOrder());
    maakoodistoToBeUpdated.setModifiedDate(maakoodistoToBeMerged.getModifiedDate());
    maakoodistoToBeUpdated.setParentItemLocalId(maakoodistoToBeMerged.getParentItemLocalId());
    maakoodistoToBeUpdated.setParentCode(maakoodistoToBeMerged.getParentCode());
    maakoodistoToBeUpdated.setExplanatoryNotes(maakoodistoToBeMerged.getExplanatoryNotes());
    maakoodistoToBeUpdated.setClassificationIndexEntry(
            updateClassificationIndexEntry(maakoodistoToBeMerged.getClassificationIndexEntry(),
                    maakoodistoToBeUpdated.getClassificationIndexEntry()));
    maakoodistoToBeUpdated.setExplanatoryNotes(maakoodistoToBeMerged.getExplanatoryNotes());
    maakoodistoToBeUpdated.setClassificationItemNames(
            updateClassificationItemnNames(maakoodistoToBeMerged.getClassificationItemNames(),
                    maakoodistoToBeUpdated.getClassificationItemNames()));

    return maakoodistoToBeUpdated;
  }

  private static List<ClassificationItemNames> updateClassificationItemnNames(
      List<ClassificationItemNames> classificationItemNamesTobeMerged,
      List<ClassificationItemNames> classificationItemNamesToBeUpdated) {

    for (int i = 0; i < classificationItemNamesToBeUpdated.size(); i++) {
      classificationItemNamesToBeUpdated.get(i).setLangName(classificationItemNamesTobeMerged.get(i).getLangName());
      classificationItemNamesToBeUpdated.get(i).setLang(classificationItemNamesTobeMerged.get(i).getLang());
      classificationItemNamesToBeUpdated.get(i).setName(classificationItemNamesTobeMerged.get(i).getName());
    }

    return classificationItemNamesToBeUpdated;
  }

  private static List<ClassificationIndexEntry> updateClassificationIndexEntry(
      List<ClassificationIndexEntry> classificationIndexEntryToBeMerged,
      List<ClassificationIndexEntry> classificationIndexEntryToBeUpdated) {

    for (int i = 0; i < classificationIndexEntryToBeUpdated.size(); i++) {
      classificationIndexEntryToBeUpdated.get(i).setText(classificationIndexEntryToBeMerged.get(i).getText());
    }    

    return classificationIndexEntryToBeUpdated;
  }

  private static Classification updateClassification(Classification classificationToBeMerged,
                                                     Classification classificationToBeUpdated) {

    classificationToBeUpdated.setLocalId(classificationToBeMerged.getLocalId());
    classificationToBeUpdated.setInternationalRecommendation(classificationToBeMerged.isInternationalRecommendation());
    classificationToBeUpdated.setNationalRecommendation(classificationToBeMerged.isNationalRecommendation());
    classificationToBeUpdated.setClassificationName(
        updateClassificationName(classificationToBeMerged.getClassificationName(), classificationToBeUpdated.getClassificationName()));
    classificationToBeUpdated.setClassificationDescription(
        updateClassificationDescription(classificationToBeMerged.getClassificationDescription(), classificationToBeUpdated.getClassificationDescription()));

    return classificationToBeUpdated;
  }

  private static List<ClassificationName> updateClassificationName(
      List<ClassificationName> classificationNameToBeMerged,
      List<ClassificationName> classificationNameToBeUpdated) {

    for (int i = 0; i < classificationNameToBeUpdated.size(); i++) {
      classificationNameToBeUpdated.get(i).setLangName(classificationNameToBeMerged.get(i).getLangName());
      classificationNameToBeUpdated.get(i).setLang(classificationNameToBeMerged.get(i).getLang());
      classificationNameToBeUpdated.get(i).setName(classificationNameToBeMerged.get(i).getName());
    }

    return classificationNameToBeUpdated;
  }

  private static List<ClassificationDescription> updateClassificationDescription(
      List<ClassificationDescription> classificationDescriptionToBeMerged,
      List<ClassificationDescription> classificationDescriptionToBeUpdated) {

    for (int i = 0; i < classificationDescriptionToBeUpdated.size(); i++) {
      classificationDescriptionToBeUpdated.get(i).setLangName(classificationDescriptionToBeMerged.get(i).getLangName());
      classificationDescriptionToBeUpdated.get(i).setLang(classificationDescriptionToBeMerged.get(i).getLang());
      classificationDescriptionToBeUpdated.get(i).setDescription(classificationDescriptionToBeMerged.get(i).getDescription());
    }

    return classificationDescriptionToBeUpdated;
  }

  /**
   * Creates a Maakoodisto object with identical values except for the given
   * entityId
   * 
   * @param entityId - ID of the Maakoodisto i.e. "004" "008" "012 etc.
   * @return - Maakoodisto object
   */
  private static Maakoodisto createMaakoodisto(String entityId) {

    List<ClassificationName> classificationNames = new ArrayList<>();
    List<ClassificationDescription> classificationDescriptions = new ArrayList<>();
    List<ClassificationIndexEntry> classificationIndexEntries = new ArrayList<>();
    List<ClassificationItemNames> classificationItemNamesList = new ArrayList<>();

    ClassificationName classificationName = ClassificationName.builder()
        .langName("suomi")
        .lang("fi")
        .name("valtiot ja maat")
        .build();

    ClassificationDescription classificationDescription = ClassificationDescription.builder()
        .langName("suomi")
        .lang("fi")
        .description("ISO 3166 -standardin mukaiset kolminumeroiset valtioiden tunnukset")
        .build();

    ClassificationIndexEntry classificationIndexEntry = ClassificationIndexEntry.builder()
        .text(Collections.emptyList())
        .build();

    classificationNames.add(classificationName);
    classificationDescriptions.add(classificationDescription);
    classificationIndexEntries.add(classificationIndexEntry);

    Classification classification = Classification.builder()
        .localId("valtio_1_20120101")
        .internationalRecommendation(true)
        .nationalRecommendation(true)
        .classificationDescription(classificationDescriptions)
        .classificationName(classificationNames)
        .build();

    ClassificationItemNames classificationItemNames = ClassificationItemNames.builder()
        .langName("suomi")
        .lang("fi")
        .name("Afghanistan")
        .build();

    classificationItemNamesList.add(classificationItemNames);

    Maakoodisto maakoodisto = Maakoodisto.builder()
        .classification(classification)
        .localId("valtio_1_20120101/004")
        .level(1)
        .code(entityId) // ID for Classification Entity OneToOne
        .order(10)
        .modifiedDate("1899-12-31T22:00:00Z")
        .parentItemLocalId(null)
        .parentCode(null)
        .explanatoryNotes(Collections.emptyList())
        .classificationIndexEntry(classificationIndexEntries)
        .classificationItemNames(classificationItemNamesList)
        .build();

    maakoodisto.setClassificationIndexEntry(classificationIndexEntries);
    maakoodisto.setClassificationItemNames(classificationItemNamesList);
    classification.setClassificationName(classificationNames);
    classification.setClassificationDescription(classificationDescriptions);

    return maakoodisto;
  }

  private static List<String> createStringListWithSomeLines() {
    List<String> updatedTexts = new ArrayList<>();
    updatedTexts.add("TÄMÄ");
    updatedTexts.add("ON");
    updatedTexts.add("UPDATETEST");

    return updatedTexts;
  }

}
