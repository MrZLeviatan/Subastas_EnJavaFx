package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.controller.service.IModelFactoryController;
import co.edu.uniquindio.subastasUq.exceptions.AnuncianteException;
import co.edu.uniquindio.subastasUq.exceptions.CompradorException;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.CompradorDto;
import co.edu.uniquindio.subastasUq.mapping.dto.ProductoDto;
import co.edu.uniquindio.subastasUq.mapping.mappers.SubastaMapper;
import co.edu.uniquindio.subastasUq.model.*;

import java.util.List;

public class ModelFactoryController implements IModelFactoryController {

    private AnuncianteDto anuncianteDtoLogeado;
    private CompradorDto compradorDtoLogeado;
    SubastasUq subastaUq;

    SubastaMapper mapper = SubastaMapper.INSTANCE;

    //metodo para reiniciarAlanunciante y al comprador Dto
    public void cerrarSeccion(){
        anuncianteDtoLogeado =null;
        compradorDtoLogeado =null;
    }


    //obtiene el comprador que este logeado
    public CompradorDto getCompradorDtoLoegeado(){
        return compradorDtoLogeado;
    }

    //obtiene el anunciante que este logeado
    public AnuncianteDto getAnuncianteDtoLogeado(){
        return anuncianteDtoLogeado;
    }



    //metodo que transforma la lista de anuncios filtrada en una de anuncios dto
    public List<AnuncioDto> filtrarAnuncio(String codigo,String nombreAnunciate,String nombreProducto){
        return mapper.getAnunciosDto(subastaUq.filtrarProductos(codigo,nombreAnunciate,nombreProducto)) ;
    }


    //metodo que obtiene toda la lista de anuncios de la subasta
    public List<AnuncioDto> obtenerAnuncios() {
        return mapper.getAnunciosDto(subastaUq.getListaAnuncios());
    }

    public List<ProductoDto> obtenerProductos() {
        Anunciante anunciante=subastaUq.obtenerAnunciante(anuncianteDtoLogeado.cedula());
        return mapper.getProductosDto(anunciante.getListaProductoAnunciante());
    }

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
            System.out.println("entra al modelFactory");
            if (!subastaUq.usuarioExiste(compradorDto.cedula())&&!subastaUq.correoExistente(compradorDto.usuarioDto().correo())) {
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
    public boolean deleteComprador(String cedula) throws CompradorException {
        Comprador comprador=null;
        comprador=subastaUq.obtenerComprador(cedula);
        if(comprador==null){
            throw new CompradorException(" el comprador no existe");
        }else {
            subastaUq.deleteUsuario(comprador);
            return true;
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
    public boolean deleteAnunciante(String cedula) throws AnuncianteException {
        Anunciante anunciante=null;
        anunciante=subastaUq.obtenerAnunciante(cedula);
        if(anunciante==null){
            throw new AnuncianteException("el anunciante no existe");
        }else {
            subastaUq.deleteUsuario(anunciante);
            return true;
        }

    }

    @Override
    public void addProducto(ProductoDto productoDto){ //no se que condicionales ponerle a eso
        Producto producto= mapper.productoDtoToProducto(productoDto);
        subastaUq.addProductoAnunciante(producto,anuncianteDtoLogeado.cedula());
    }



    public boolean addAnuncio(AnuncioDto anuncioDto){
        Anunciante anunciante=subastaUq.obtenerAnunciante(anuncianteDtoLogeado.cedula());
        try {
            if(anunciante.getListaAnunciosAnunciante().size()<3){
                Anuncio anuncio=mapper.anuncioDtoToAnuncio(anuncioDto);
                subastaUq.addAnuncio(anuncio,anuncianteDtoLogeado.cedula());
            }
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean autentificacionAnunciante(String correo, String contraseña) {
        if(subastaUq.autentificarAnunciante(correo,contraseña)){
            anuncianteDtoLogeado =mapper.anuncianteToAnuncianteDto(subastaUq.obtenerAnuncianteCorreo(correo));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean autentificacionComprador(String correo, String contraseña) {
        if(subastaUq.autetificarComprador(correo,contraseña)){
            compradorDtoLogeado =mapper.compradorToCompradorDto(subastaUq.obtenerCompradorCorreo(correo));
            return true;
        }else {
            return false;
        }
    }

}