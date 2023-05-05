package no.experis.backend.repositories;

import no.experis.backend.models.ConvertedNr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertedNrRepository extends JpaRepository<ConvertedNr,String> {
}
