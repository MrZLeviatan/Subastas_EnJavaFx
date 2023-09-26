package co.edu.uniquindio.subastasUq.mapping.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SubastaMapper {

    SubastaMapper INSTANCE= Mappers.getMapper(SubastaMapper.class);
}
