package no.experis.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "romanConvert")
public class RomanConvert {
    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private int id;

}
