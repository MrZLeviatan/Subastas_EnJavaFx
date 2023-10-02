package co.edu.uniquindio.subastasUq.mapping.mappers;

import co.edu.uniquindio.subastasUq.mapping.dto.*;
import co.edu.uniquindio.subastasUq.model.*;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SubastaMapper {




    SubastaMapper INSTANCE= Mappers.getMapper(SubastaMapper.class);


    

    @Named("productoToProductoDto")
    ProductoDto productoToProductoDto(Producto producto);

    Producto productoDtoToProducto(ProductoDto productoDto);

    @Named("anuncioToAnuncioDto")
    AnuncioDto anuncioToAnuncioDto(Anuncio anuncio);
    Anuncio anuncioDtoToAnuncio(AnuncioDto anuncioDto);


    @Named("pujaToPujaDto")
    PujaDto pujaToPujaDto (Puja puja);
    Puja pujaDtoToPuja (PujaDto pujaDto);

    @IterableMapping(qualifiedByName = "pujaToPujaDto")
    List<PujaDto> getPujasDto(List<Puja> list);


    @IterableMapping(qualifiedByName = "anuncioToAnuncioDto")
    List<AnuncioDto> getAnunciosDto(List<Anuncio> list);


    @IterableMapping(qualifiedByName = "productoToProductoDto")
    List<ProductoDto> getProductosDto(List<Producto> list);



    @Named("anuanteDtoToAnunciante")
    Anunciante anuncianteDtoToAnunciante(AnuncianteDto anuncianteDto);
    AnuncianteDto anuncianteToAnuncianteDto(Anunciante obtenerAnuncianteCorreo);


    @Named("compradorToCompradorDto")
    CompradorDto compradorToCompradorDto(Comprador comprador);
    Comprador compradorDtoToComprador(CompradorDto compradorDto);

}
