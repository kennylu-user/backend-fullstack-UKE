package no.experis.backend.services.convertedNr;
import jakarta.persistence.Convert;
import no.experis.backend.models.ConvertedNr;
import no.experis.backend.models.Logs;
import no.experis.backend.repositories.ConvertedNrRepository;
import no.experis.backend.utils.exception.ConvertedNrNotFoundException;
import no.experis.backend.utils.exception.RomanConvertNotFoundException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class ConvertedNrServiceImpl implements ConvertedNrService{
    private final ConvertedNrRepository convertedNrRepository;

    public ConvertedNrServiceImpl(ConvertedNrRepository convertedNrRepository) {
        this.convertedNrRepository = convertedNrRepository;
    }

    @Override
    public ConvertedNr findById(String id) {
        ConvertedNr cn;
        try{

            cn = convertedNrRepository.findById(id).orElseThrow(() -> new ConvertedNrNotFoundException(id));
//            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
//            Logs log = new Logs();
//            log.setRomanNr(id);
//            log.setConvertedNr(cn);
//            log.setTimeStamp(timeStamp);
//            cn.getLogs().add(log);
//            convertedNrRepository.save(cn);

        }
        catch(Exception e){
            cn = new ConvertedNr();
            cn.setId(id);
            int converted = this.convert(id);
            cn.setConverted(converted);


        }


        Logs log = new Logs();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        log.setRomanNr(id);
        log.setConvertedNr(cn);
        log.setTimeStamp(timeStamp);
        cn.getLogs().add(log);
        convertedNrRepository.save(cn);
        return convertedNrRepository.findById(id).orElseThrow(() -> new ConvertedNrNotFoundException(id));
    }

    @Override
    public Collection<ConvertedNr> findAll() {
        return convertedNrRepository.findAll();
    }

    @Override
    public ConvertedNr add(ConvertedNr entity) {
        return convertedNrRepository.save(entity);
    }

    @Override
    public void update(ConvertedNr entity) {

    }

    @Override
    public void deleteById(String s) {

    }
    @Override
    public int convert(String s){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //Process char
            numbers.add(map.get(String.format("%s",c)));
        }

        int total = 0;
        for (int i = 0; i < numbers.size()-1 ; i++) {
            if(numbers.get(i) >= numbers.get(i+1)){
                total += numbers.get(i);
                System.out.printf("%d + ",numbers.get(i));
            }else{
                total += numbers.get(i+1) - numbers.get(i);
                System.out.printf("(%d-%d) +",numbers.get(i+1),numbers.get(i));
                i++;
            }
            if(i == numbers.size()-2){
                total += numbers.get(i+1);
                System.out.printf("%d ",numbers.get(i+1));
            }

        }
        System.out.print("= ");
        return total;

    }
}
