package controller;

import dto.AccidentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.AccidentService;
import validator.ValidVin;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@Validated
public class AccidentController {
    @Autowired
    AccidentService accidentService;

    @GetMapping("/accidents")
    public List<AccidentDto> getAllAccidents(){
        return accidentService.getAllAccidents();
    }

    @GetMapping("/accident/{vin}")
    public AccidentDto getAccidentByVin(@ValidVin @PathVariable Integer vin){
        return accidentService.getAccidentByVin(vin);
    }
}
