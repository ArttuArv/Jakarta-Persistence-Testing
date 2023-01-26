package org.jakarta.persistence.api.maakoodisto.test.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "jakarta_maakoodit_luokittelun_kuvaus")
public class ClassificationDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jakarta_seqGen")
    @SequenceGenerator(name = "jakarta_seqGen", sequenceName = "jakarta_maakoodisto_seq", allocationSize = 250)
    @Column(name = "luokittelunKuvausId")
    private int id;

    @Column(name = "langName")
    private String langName;
    @Column(name = "lang")
    private String lang;
    @Column(name = "description")
    private String description;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "luokitteluId")
    private Classification classification;
}