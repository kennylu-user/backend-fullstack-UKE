package no.experis.backend.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "romanConvert")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String timeStamp;
    private String romanNr;
    @ManyToOne
    @JoinColumn
    private ConvertedNr convertedNr;
}
