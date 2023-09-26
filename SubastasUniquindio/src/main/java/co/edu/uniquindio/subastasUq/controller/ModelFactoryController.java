package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.mapping.dto.CompradorDto;
import co.edu.uniquindio.subastasUq.mapping.mappers.SubastaMapper;
import co.edu.uniquindio.subastasUq.model.SubastasUq;
import co.edu.uniquindio.subastasUq.utils.SubastaUqUtils;

public class ModelFactoryController {
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
        subastaUq=new SubastasUq();
    }

    public boolean añadirComprador(CompradorDto compradorDto){
        return true;
    }

}
