package no.experis.backend.repositories;
import no.experis.backend.models.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends JpaRepository<Logs,Integer> {
}
