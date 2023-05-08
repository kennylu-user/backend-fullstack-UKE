package no.experis.backend.services.convertedNr;
import no.experis.backend.models.ConvertedNr;
import no.experis.backend.models.Logs;
import no.experis.backend.repositories.ConvertedNrRepository;
import no.experis.backend.repositories.LogsRepository;
import no.experis.backend.utils.exception.ConvertedNrNotFoundException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ConvertedNrServiceImpl implements ConvertedNrService{
    private final ConvertedNrRepository convertedNrRepository;
    private final LogsRepository logsRepository;

    public ConvertedNrServiceImpl(ConvertedNrRepository convertedNrRepository, LogsRepository logsRepository) {
        this.convertedNrRepository = convertedNrRepository;
        this.logsRepository = logsRepository;
    }

    @Override
    public ConvertedNr findById(String id) {
        ConvertedNr cn;
        try{
            cn = convertedNrRepository.findById(id).orElseThrow(() -> new ConvertedNrNotFoundException(id));
            System.out.println(cn.getLogs());

        }
        catch(Exception e){
            cn = new ConvertedNr();
            cn.setId(id);
            int converted = this.convert(id);
            System.out.println(converted);
            cn.setConverted(converted);
            Set<Logs> logs = new HashSet<>();
            cn.setLogs(logs);
        }
        Logs log = new Logs();
        String timeStamp = new SimpleDateFormat("ss.mm.HH.dd.MM.yyyy").format(new java.util.Date());
        System.out.println("TimeStamp");
        System.out.println(timeStamp);
        log.setConvertedNr(cn);
        log.setTimeStamp(timeStamp);
        cn.getLogs().add(log);
        convertedNrRepository.save(cn);
        logsRepository.save(log);
        return cn;
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
        if(numbers.size() == 1){
            total = numbers.get(0);
        }
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
