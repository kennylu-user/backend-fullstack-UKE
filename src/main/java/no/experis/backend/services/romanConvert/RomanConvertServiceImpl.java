package no.experis.backend.services.romanConvert;

import no.experis.backend.models.RomanConvert;
import no.experis.backend.repositories.RomanConvertRepository;
import no.experis.backend.utils.exception.RomanConvertNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RomanConvertServiceImpl implements RomanConvertService {
    private final RomanConvertRepository romanConvertRepository;

    public RomanConvertServiceImpl(RomanConvertRepository romanConvertRepository) {
        this.romanConvertRepository = romanConvertRepository;
    }

    @Override
    public RomanConvert findById(Integer id) {
        return romanConvertRepository.findById(id).orElseThrow(() -> new RomanConvertNotFoundException(id));
    }

    @Override
    public Collection<RomanConvert> findAll() {
        return romanConvertRepository.findAll();
    }

    @Override
    public RomanConvert add(RomanConvert entity) {
        return romanConvertRepository.save(entity);
    }

    @Override
    public void update(RomanConvert entity) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
