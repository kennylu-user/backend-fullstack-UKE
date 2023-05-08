package no.experis.backend.services.logs;

import no.experis.backend.models.Logs;
import no.experis.backend.repositories.LogsRepository;
import no.experis.backend.utils.exception.LogsNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class LogsServiceImpl implements LogsService{
    private final LogsRepository logsRepository;

    public LogsServiceImpl(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    @Override
    public Logs findById(Integer id) {
        return logsRepository.findById(id).orElseThrow(() -> new LogsNotFoundException(id));
    }

    @Override
    public Collection<Logs> findAll() {
        return logsRepository.findAll();
    }

    @Override
    public Logs add(Logs entity) {
        return logsRepository.save(entity);
    }

    @Override
    public void update(Logs entity) {
        logsRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        logsRepository.deleteById(id);
    }
}
