package no.experis.backend.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String timeStamp;
//    private String romanNr;
    @ManyToOne
    @JoinColumn(name = "convertedNr_id", nullable = false)
    private ConvertedNr convertedNr;
}
