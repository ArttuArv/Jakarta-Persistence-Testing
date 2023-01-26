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
@Table(name = "jakarta_maakoodit_luokittelun_nimikkeet")
public class ClassificationItemNames {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jakarta_seqGen")
    @SequenceGenerator(name = "jakarta_seqGen", sequenceName = "jakarta_maakoodisto_seq", allocationSize = 250)
    @Column(name = "luokittelunNimikkeetId")
    private int id;

    @Column(name = "langName")
    private String langName;

    @Column(name = "lang")
    private String lang;

    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maakoodistoId")
    Maakoodisto maakoodisto;
}
