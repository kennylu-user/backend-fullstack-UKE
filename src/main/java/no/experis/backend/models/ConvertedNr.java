package no.experis.backend.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "convertNr")
public class ConvertedNr {
    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private String id;
    @OneToMany(mappedBy = "convertedNr")
    private Set<Logs> logs;
    private int converted;

}
