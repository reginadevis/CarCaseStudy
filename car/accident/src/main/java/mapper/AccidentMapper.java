package mapper;

import dto.AccidentDto;
import entity.Accident;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccidentMapper {

    AccidentMapper INSTANCE = Mappers.getMapper(AccidentMapper.class);

    AccidentDto accidentToAccidentDto(Accident accident);

    List<AccidentDto> accidentListtoAccidentDtoList(List<Accident> accidents);
}
