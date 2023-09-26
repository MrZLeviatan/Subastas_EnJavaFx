import co.edu.uniquindio.subastasUq.model.SubastasUq;
import co.edu.uniquindio.subastasUq.utils.SubastaUqUtils;
import org.junit.jupiter.api.Test;

import static co.edu.uniquindio.subastasUq.utils.SubastaUqUtils.inicializarDatos;

public class UsuariosTest {
    @Test
    public void test01() throws Exception {
        SubastasUq subastasUq= inicializarDatos();
        System.out.println(subastasUq.getListaAnunciantes().get(0).getApellido());
    }
}
