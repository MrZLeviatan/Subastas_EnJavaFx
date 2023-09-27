package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.controller.service.IModelFactoryController;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.CompradorDto;
import co.edu.uniquindio.subastasUq.mapping.dto.ProductoDto;
import co.edu.uniquindio.subastasUq.mapping.mappers.SubastaMapper;
import co.edu.uniquindio.subastasUq.model.*;

public class ModelFactoryController implements IModelFactoryController {
    SubastasUq subastaUq;

    SubastaMapper mapper = SubastaMapper.INSTANCE;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        subastaUq = new SubastasUq();
    }

    public SubastasUq getSubastaUq() {
        return subastaUq;
    }
    @Override
    public boolean addComprador(CompradorDto compradorDto) { //añade el compradorDto
        try {
            if (!subastaUq.usuarioExiste(compradorDto.cedula())) {
                Comprador comprador = mapper.compradorDtoToComprador(compradorDto);
                getSubastaUq().addUsuario(comprador);
            }
            return true;
        }catch (Exception e){ //porque no me deja poner el CompradorException
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean addAnunciante(AnuncianteDto anuncianteDto){
        try {
            if(!subastaUq.usuarioExiste(anuncianteDto.cedula())){
                Anunciante anunciante= mapper.anuncianteDtoToAnunciante(anuncianteDto);
                getSubastaUq().addUsuario(anunciante);
            }
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public void addProducto(ProductoDto productoDto, String cedula){ //no se que condicionales ponerle a eso
        Producto producto= mapper.productoDtoToProducto(productoDto);
        subastaUq.addProductoAnunciante(producto,cedula);
    }



    @Override
    public boolean addAnuncio(AnuncioDto anuncioDto, String cedula){
        Anunciante anunciante=subastaUq.obtenerAnunciante(cedula);
        try {
            if(anunciante.getListaAnunciosAnunciante().size()<3){
                Anuncio anuncio=mapper.anuncioDtoToAnuncio(anuncioDto);
                subastaUq.addAnuncio(anuncio,cedula);
            }
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }
}