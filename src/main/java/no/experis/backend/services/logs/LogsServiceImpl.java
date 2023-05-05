package no.experis.backend.services.logs;

import no.experis.backend.models.Logs;
import no.experis.backend.repositories.LogsRepository;

import java.util.Collection;

public class LogsServiceImpl implements LogsService{
    private final LogsRepository logsRepository;

    public LogsServiceImpl(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    @Override
    public Logs findById(Integer integer) {
        return null;
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

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
