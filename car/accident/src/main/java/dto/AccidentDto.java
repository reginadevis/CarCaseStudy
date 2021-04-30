package dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AccidentDto {

    Integer vin;

    Date accidentDate;

    String description;
}
