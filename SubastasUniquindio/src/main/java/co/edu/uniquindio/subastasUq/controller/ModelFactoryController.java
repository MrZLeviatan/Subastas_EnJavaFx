package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.controller.service.IModelFactoryController;
import co.edu.uniquindio.subastasUq.exceptions.AnuncianteException;
import co.edu.uniquindio.subastasUq.exceptions.CompradorException;
import co.edu.uniquindio.subastasUq.mapping.dto.*;
import co.edu.uniquindio.subastasUq.mapping.mappers.SubastaMapper;
import co.edu.uniquindio.subastasUq.model.*;
import co.edu.uniquindio.subastasUq.utils.SubastaUqUtils;

import java.util.List;

public class ModelFactoryController implements IModelFactoryController {

    //variables "globales" de la clase
    private AnuncianteDto anuncianteDtoLogeado;
    private CompradorDto compradorDtoLogeado;
    SubastasUq subastaUq;
    SubastaMapper mapper = SubastaMapper.INSTANCE;

    //final variables globales de la clase


    //metodos Singleton------------------------------------------------------------------------
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE;

        static {
            try {
                eINSTANCE = new ModelFactoryController();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }//me llama al model factory

    public ModelFactoryController() throws Exception {
        subastaUq = SubastaUqUtils.inicializarDatos();
    }

    public SubastasUq getSubastaUq() {
        return subastaUq;
    } //me meto ala subasta

    //final metodosSingleton----------------------------------------------


    //metodo cerrarSeccion-------------------------------------
    public void cerrarSeccion(){
        anuncianteDtoLogeado =null;
        compradorDtoLogeado =null;
    }

    //final metodo cerrarSeccion------------------------------------

    //metodos Anunciante------------------------------------------------------------------------------

    public AnuncianteDto getAnuncianteDtoLogeado(){  //obtiene el anunciante que este logeado
        return anuncianteDtoLogeado;
    }


    @Override
    public boolean addAnunciante(AnuncianteDto anuncianteDto) {
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
    public boolean autentificacionAnunciante(String correo, String contraseña) {
        if(subastaUq.autentificarAnunciante(correo,contraseña)){
            anuncianteDtoLogeado =mapper.anuncianteToAnuncianteDto(subastaUq.obtenerAnuncianteCorreo(correo));
            return true;
        }else {
            return false;
        }
    }
    //finalMetodosAnunciante--------------------------------------------------------------


    //metodos Comprador--------------------------------------------------------------------

    public CompradorDto getCompradorDtoLoegeado(){ //obtiene el comprador que este logeado
        return compradorDtoLogeado;
    }
    @Override
    public boolean addComprador(CompradorDto compradorDto) { //añade el compradorDto
        try {
            System.out.println("entra al modelFactory");
            if (!subastaUq.usuarioExiste(compradorDto.cedula())) {
                if(!subastaUq.correoExistente(compradorDto.usuarioDto().correo())){
                    Comprador comprador = mapper.compradorDtoToComprador(compradorDto);
                    getSubastaUq().addUsuario(comprador);
                }else {
                    return false;
                }

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
    public boolean autentificacionComprador(String correo, String contraseña) {
        if(subastaUq.autetificarComprador(correo,contraseña)){
            compradorDtoLogeado =mapper.compradorToCompradorDto(subastaUq.obtenerCompradorCorreo(correo));
            return true;
        }else {
            return false;
        }
    }


    //final metodos Comprador----------------------------------------------------------------

    //metodos productos-------------------------------------------------------------------
    public List<ProductoDto> obtenerProductos() {
        Anunciante anunciante=subastaUq.obtenerAnunciante(anuncianteDtoLogeado.cedula());
        return mapper.getProductosDto(anunciante.getListaProductoAnunciante());
    }



    @Override
    public void addProducto(ProductoDto productoDto){ //no se que condicionales ponerle a eso
        Producto producto= mapper.productoDtoToProducto(productoDto);
        subastaUq.addProductoAnunciante(producto,anuncianteDtoLogeado.cedula());
    }
    //final metodo productos----------------------------------------------------

    //metodos anuncio--------------------------------------------------------------------------

    //metodo que transforma la lista de anuncios filtrada en una de anuncios dto
    public List<AnuncioDto> filtrarAnuncio(String codigo,String nombreAnunciate,String nombreProducto){
        return mapper.getAnunciosDto(subastaUq.filtrarProductos(codigo,nombreAnunciate,nombreProducto)) ;
    }


    //metodo que obtiene toda la lista de anuncios de la subasta
    public List<AnuncioDto> obtenerAnuncios() {
        return mapper.getAnunciosDto(subastaUq.getListaAnuncios());
    }

    public List<AnuncioDto> obtenerAnunciosAnunciante(){
        Anunciante anunciante=mapper.anuncianteDtoToAnunciante(anuncianteDtoLogeado);
        return mapper.getAnunciosDto(anunciante.getListaAnunciosAnunciante());
    }

    //final metodos anuncio---------------------------------------------------------------------


    //metodos pujas-----------------------------------------------------------------------

    public List<PujaDto> obtenerPujasAnuncio(AnuncioDto anuncioSelecionado) {
        Anunciante anunciante=mapper.anuncianteDtoToAnunciante(anuncianteDtoLogeado);
        List<Puja>listaPujaAnuncio=anunciante
                .getListaAnunciosAnunciante()
                .stream()
                .filter(anuncio -> anuncio.getCodigoAnuncio().equals(anuncioSelecionado.codigoAnuncio()))
                .findFirst()
                .get()
                .getListaPujaProducto();
        return mapper.getPujasDto(listaPujaAnuncio);
    }

    //final metodos puja-------------------------------------------------------------------

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

}