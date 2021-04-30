package service;

import dto.AccidentDto;
import entity.Accident;
import mapper.AccidentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.AccidentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AccidentService {

    @Autowired
    AccidentRepository accidentRepository;

    public List<AccidentDto> getAllAccidents(){

        List<Accident> accidents = null;
        List<AccidentDto> accidentDtos = null;
        try {
            accidents = accidentRepository.findAll();
            accidentDtos = AccidentMapper.INSTANCE.accidentListtoAccidentDtoList(accidents);
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Some error occured while processing. Please contact the application administrator");
        }
        return accidentDtos;
    }

    public AccidentDto getAccidentByVin(Integer vin){
        Accident accident = null;
        AccidentDto accidentDto = null;
        try{
            accident = accidentRepository.getById(vin);
            accidentDto = AccidentMapper.INSTANCE.accidentToAccidentDto(accident);
        }catch (Exception exception){
            if(exception.getMessage().contains("Unable to find entity")){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Entry for the provided vin is not present");
            }
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Some error occured while processing. Please contact the application administrator");
        }
        return accidentDto;
    }
}
