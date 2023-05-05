package no.experis.backend.repositories;
import no.experis.backend.models.RomanConvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RomanConvertRepository extends JpaRepository<RomanConvert,Integer> {
}

