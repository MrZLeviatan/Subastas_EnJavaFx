package co.edu.uniquindio.SubastasUniquindio.controller;
import co.edu.uniquindio.SubastasUniquindio.controller.services.IModelFactoryController;
import co.edu.uniquindio.SubastasUniquindio.exceptions.PersonaExeption;
import co.edu.uniquindio.SubastasUniquindio.mapping.dto.PersonaDto;
import co.edu.uniquindio.SubastasUniquindio.mapping.dto.UsuarioDto;
import co.edu.uniquindio.SubastasUniquindio.mapping.mappers.SubastaMapper;
import co.edu.uniquindio.SubastasUniquindio.model.Persona;
import co.edu.uniquindio.SubastasUniquindio.model.SubastasUq;
import co.edu.uniquindio.SubastasUniquindio.util.SubastaUtils;
import org.mapstruct.Named;

public class ModelFactoryController implements IModelFactoryController {

    SubastasUq subastasUq;
    SubastaMapper mapper= SubastaMapper.INSTANCE;

    //creamos el singleton
    public static class SingletonHolder {
        private static final ModelFactoryController eINSTANCE = new ModelFactoryController();

    }

    //metodo para obtener la instancia
    public static ModelFactoryController getInstance(){return SingletonHolder.eINSTANCE; }

    public ModelFactoryController(){
        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }

    public SubastasUq getSubastasUq() {
        return subastasUq;
    }

    private void cargarDatosBase() {
        subastasUq= SubastaUtils.inicializarDatos();
    }

    public boolean agregarPersona(PersonaDto personaDto) throws PersonaExeption {
            if(!subastasUq.personaExiste(personaDto.cedula())){
                Persona persona= mapper.personaDtoToPersona(personaDto);
                getSubastasUq().agregarUsuario(persona);
                return true;
            }else {
                throw new PersonaExeption("la persona no es valida");
            }

    }


}
