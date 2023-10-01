package co.edu.uniquindio.subastasUq.mapping.mappers;

import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.CompradorDto;
import co.edu.uniquindio.subastasUq.mapping.dto.ProductoDto;
import co.edu.uniquindio.subastasUq.model.Anunciante;
import co.edu.uniquindio.subastasUq.model.Anuncio;
import co.edu.uniquindio.subastasUq.model.Comprador;
import co.edu.uniquindio.subastasUq.model.Producto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SubastaMapper {

    SubastaMapper INSTANCE= Mappers.getMapper(SubastaMapper.class);

    @Named("compradorToCompradorDto")
    CompradorDto compradorToCompradorDto(Comprador comprador);

    Comprador compradorDtoToComprador(CompradorDto compradorDto);


    @Named("anuncianteToAnuncianteDto")
    AnuncianteDto anuncianteToAnuncianteDto(Anunciante anunciante);

    Anunciante anuncianteDtoToAnunciante(AnuncianteDto anuncianteDto);

    @Named("productoToProductoDto")
    ProductoDto productoToProductoDto(Producto producto);

    Producto productoDtoToProducto(ProductoDto productoDto);

    @Named("anuncioToAnuncioDto")
    AnuncioDto anuncioToAnuncioDto(Anuncio anuncio);
    Anuncio anuncioDtoToAnuncio(AnuncioDto anuncioDto);


    @IterableMapping(qualifiedByName = "anuncioToAnuncioDto")
    List<AnuncioDto> getAnunciosDto(List<Anuncio> listaAnuncios);


    @IterableMapping(qualifiedByName = "productoToProductoDto")
    List<ProductoDto> getProductosDto(List<Producto> lisaProductos);

}
