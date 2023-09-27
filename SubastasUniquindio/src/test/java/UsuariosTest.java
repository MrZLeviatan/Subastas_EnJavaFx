import co.edu.uniquindio.subastasUq.model.*;
import org.junit.jupiter.api.Test;

public class UsuariosTest {
    @Test
    public void testAgregarUsuarioAnunciante() throws Exception {
        SubastasUq subastasUq= new SubastasUq(); //instancia
        subastasUq.addUsuario( new Anunciante("andrey","122","123445",12,
                new Usuario("andrey3681","1234","andrey3681.ay@gmail.com"))); //crea y añade un anunciante
        subastasUq.getListaAnunciantes().forEach(anunciante -> System.out.println(anunciante.getApellido()));
        Anunciante anunciante=subastasUq.obtenerAnunciante("123445");
        anunciante.addProducto(new Producto("cosa","223",null,TipoProductos.BIENRAIZ));
        System.out.println(anunciante.getListaProductoAnunciante().get(0).getNombre());

    }

    @Test
    public void testAgregarUsarioComprador()throws Exception{
        SubastasUq subastasUq= new SubastasUq(); //instancia
        subastasUq.addUsuario((new Comprador("luis", "fernando", "12345", 13, "addsadada",
                new Usuario("luis123","12345","luis@gmail")))); //crea y añade un comprador
        subastasUq.getListaComprador().forEach(comprador -> System.out.println(comprador.getUsuario()));
    }

    @Test
    public void testCorreoExiste01() throws Exception {
        //en este test se verifica que si una persona con cedula diferente pero con el mismo correo trata de registrarse salta la exception
        SubastasUq subastasUq= new SubastasUq(); //instancia
        subastasUq.addUsuario((new Comprador("luis", "fernando", "12345", 13, "addsadada",
                new Usuario("luis123","12345","luis@gmail")))); //crea y añade un comprador
        subastasUq.addUsuario((new Comprador("luis", "fernando", "123456", 13, "addsadada",
                new Usuario("luis123","12345","luis@gmail"))));
        subastasUq.getListaComprador().forEach(comprador -> System.out.println(comprador.getUsuario().getCorreo()));
    }

    @Test
    public void testCorreoExiste02() throws Exception {
        SubastasUq subastasUq= new SubastasUq(); //instancia
        subastasUq.addUsuario((new Comprador("luis", "fernando", "12345", 13, "addsadada",
                new Usuario("luis123","12345","luis@gmail")))); //crea y añade un comprador
        subastasUq.addUsuario( new Anunciante("andrey","122","12345",12,
                new Usuario("andrey3681","1234","andrey3681.ay@gmail.com"))); //crea y añade un anunciante
    }

    @Test
    public void test(){
        SubastasUq subastasUq= new SubastasUq(); //instancia
        subastasUq.addUsuario(null);

    }

}
