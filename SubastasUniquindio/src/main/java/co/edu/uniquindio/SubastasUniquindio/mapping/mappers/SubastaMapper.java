package co.edu.uniquindio.SubastasUniquindio.mapping.mappers;
import co.edu.uniquindio.SubastasUniquindio.mapping.dto.PersonaDto;
import co.edu.uniquindio.SubastasUniquindio.model.Persona;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SubastaMapper {

    SubastaMapper INSTANCE = Mappers.getMapper(SubastaMapper.class);
    @Named("personaToPersonaDto")
    PersonaDto personaToPersonaDto(Persona persona);

    Persona personaDtoToPersona(PersonaDto personaDto);


}
