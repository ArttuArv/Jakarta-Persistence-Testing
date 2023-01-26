package org.jakarta.persistence.api.maakoodisto.test.models;

import java.util.*;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "jakarta_maakoodit_luokittelu")
public class Classification {

    /*
    @Id
    @Column(name = "maakoodistoId")
    private String id; */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jakarta_seqGen")
    @SequenceGenerator(name = "jakarta_seqGen", sequenceName = "jakarta_maakoodisto_seq", allocationSize = 250)
    @Column(name = "luokitteluId")
    private int id;

    @Column(name = "localId")
    private String localId;

    @Column(name = "internationalRecommendation")
    private boolean internationalRecommendation;

    @Column(name = "nationalRecommendation")
    private boolean nationalRecommendation;

    /*
    @MapsId("maakoodistoId")
    @OneToOne
    @JoinColumn(name = "maakoodistoId")
    private Maakoodisto maakoodisto;
     */

    @OneToOne(mappedBy = "classification", cascade = CascadeType.ALL)
    private Maakoodisto maakoodisto;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "classification")
    private List<ClassificationName> classificationName = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "classification")
    private List<ClassificationDescription> classificationDescription = new ArrayList<>();

    public void setClassificationName(List<ClassificationName> classificationName) {
        this.classificationName = classificationName;

        if (null != classificationName) {
            for (ClassificationName cn : classificationName) {
                cn.setClassification(this);
            }
        }
    }

    public void setClassificationDescription(List<ClassificationDescription> classificationDescription) {
        this.classificationDescription = classificationDescription;

        if (null != classificationDescription) {
            for (ClassificationDescription cd : classificationDescription) {
                cd.setClassification(this);
            }
        }
    }

}
