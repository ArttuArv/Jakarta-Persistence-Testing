package org.jakarta.persistence.api.maakoodisto.test.models;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "jakarta_maakoodit")
@NamedQuery(name = "Maakoodisto.findAll", query = "SELECT m FROM Maakoodisto m")
public class Maakoodisto {
/*
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "maakoodisto")
    @PrimaryKeyJoinColumn
    //@JoinColumn(name = "codeString")
    private Classification classification; */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "luokitteluId", referencedColumnName = "luokitteluId")
    protected Classification classification;

    @Column(name = "localId")
    protected String localId;

    @Column(name = "levelNumber")
    protected int level;

    @Id
    @Column(name = "codeString")
    protected String code;

    @Column(name = "orderNumber")
    protected int order;

    @Column(name = "modifiedDate")
    protected String modifiedDate;

    @Column(name = "parentItemLocalId")
    protected String parentItemLocalId;

    @Column(name = "parentCode")
    protected String parentCode;

    @Column(name = "PostPersistMessage")
    protected String postPersistMessage;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "jakarta_maakoodit_lisatiedot",
            joinColumns = @JoinColumn(name = "maakoodistoId"))
    @Column(name = "explanatoryNotes")
    protected List<String> explanatoryNotes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maakoodisto", fetch = FetchType.LAZY)
    protected List<ClassificationIndexEntry> classificationIndexEntry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maakoodisto", fetch = FetchType.LAZY)
    protected List<ClassificationItemNames> classificationItemNames;

    public void setClassificationIndexEntry(List<ClassificationIndexEntry> classificationIndexEntry) {
        this.classificationIndexEntry = classificationIndexEntry;

        if (null != classificationIndexEntry) {
            for (ClassificationIndexEntry cie: classificationIndexEntry) {
                cie.setMaakoodisto(this);
            }
        }
    }

    public void setClassificationItemNames(List<ClassificationItemNames> classificationItemNames) {
        this.classificationItemNames = classificationItemNames;

        if (null != classificationItemNames) {
            for (ClassificationItemNames cin : classificationItemNames) {
                cin.setMaakoodisto(this);
            }
        }
    }

    @PostPersist
    public void insertPostPersistMessage() {
        this.postPersistMessage = "Entity persisted";
    }

    @PostUpdate
    public void insertPostUpdateMessage() {
        this.postPersistMessage = "Entity updated";
    }
}
