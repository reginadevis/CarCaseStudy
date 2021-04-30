package service;

import dto.AccidentDto;
import entity.Accident;
import mapper.AccidentMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        try {
            accidents = accidentRepository.findAll();
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Some error occured while processing. Please contact the application administrator");
        }
        return AccidentMapper.INSTANCE.accidentListtoAccidentDtoList(accidents);
    }

    public AccidentDto getAccidentByVin(Integer vin){
        Accident accident = null;

        try{
            accident = accidentRepository.getById(vin);
        }catch(EntityNotFoundException ex){
            System.out.println("EntityNotFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Entry for the provided vin is not present");
        }catch (Exception exception){
            exception.printStackTrace();
            System.out.println(exception.toString());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Some error occured while processing. Please contact the application administrator");
        }
        return AccidentMapper.INSTANCE.accidentToAccidentDto(accident);
    }
}
