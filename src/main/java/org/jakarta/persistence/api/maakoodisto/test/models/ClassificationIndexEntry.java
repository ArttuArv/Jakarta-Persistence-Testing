package org.jakarta.persistence.api.maakoodisto.test.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import org.jakarta.persistence.api.maakoodisto.test.models.Maakoodisto.MaakoodistoBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "jakarta_maakoodit_luokittelun_hakutieto")
public class ClassificationIndexEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jakarta_seqGen")
    @SequenceGenerator(name = "jakarta_seqGen", sequenceName = "jakarta_maakoodisto_seq", allocationSize = 250)
    @Column(name = "luokittelunHakutietoId")
    private int id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "jakarta_maakoodit_luokittelun_hakutieto_teksti",
            joinColumns = @JoinColumn(name = "luokittelunHakutietoId"))
    @Column(name = "text")
    private List<String> text;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "maakoodistoId")
    private Maakoodisto maakoodisto;

}