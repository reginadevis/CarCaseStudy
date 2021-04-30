package controller;

import dto.AccidentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.AccidentService;

import java.util.List;

@RestController
public class AccidentController {
    @Autowired
    AccidentService accidentService;

    @GetMapping("/accidents")
    public List<AccidentDto> getAllAccidents(){
        return accidentService.getAllAccidents();
    }

    @GetMapping("/accident/{vin}")
    public AccidentDto getAccidentByVin(@PathVariable Integer vin){
        return accidentService.getAccidentByVin(vin);
    }
}
