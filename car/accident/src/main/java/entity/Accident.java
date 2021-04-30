package entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name="accident")
public class Accident {

    @Id
    Integer vin;

    Date accidentDate;

    String description;

}
