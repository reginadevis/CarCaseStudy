package service;

import dto.AccidentDto;
import entity.Accident;
import mapper.AccidentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccidentRepository;

import java.util.List;

@Service
public class AccidentService {

    @Autowired
    AccidentRepository accidentRepository;

    public List<AccidentDto> getAllAccidents(){

        List<Accident> accidents = accidentRepository.findAll();

        return AccidentMapper.INSTANCE.accidentListtoAccidentDtoList(accidents);
    }

    public AccidentDto getAccidentByVin(Integer vin){
        return AccidentMapper.INSTANCE.accidentToAccidentDto(accidentRepository.getById(vin));
    }
}
