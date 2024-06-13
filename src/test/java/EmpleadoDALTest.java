import accesoadatos.EmpleadoDAL;
import entidadesdenegocio.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class EmpleadoDALTest {

    @Test
    public void guardarTest() throws SQLException{
        Empleado empleado = new Empleado();

        empleado.setNombre("Lester Adam");
        empleado.setApellido("Rivera Linarez");
        empleado.setEmail("lester@gmail.com");
        empleado.setTelefono("8449-2983");
        empleado.setPuesto("Desarrollador");

        int esperando = 1;
        int actual = EmpleadoDAL.guardar(empleado);
        Assertions.assertEquals(esperando, actual);
    }


    @Test
    public void obtenerTodosTest() throws SQLException{
        int esperado = 3;
        int actual = EmpleadoDAL.obtenerTodos().size();
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void modificarTest() throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setId(3);
        empleado.setNombre("Lester Adam");
        empleado.setApellido("Rivera Linarez");
        empleado.setEmail("lester@gmail.com");
        empleado.setTelefono("8449-2983");
        empleado.setPuesto("Desarrollador");

        int esperado = 1;
        int actual = EmpleadoDAL.modificar(empleado);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void eliminarTest() throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setId(3);

        int esperado = 1;
        int actual = EmpleadoDAL.eliminar(empleado);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void obtenerDatosFiltradosTest() throws SQLException{
        Empleado empleado = new Empleado();
        empleado.setApellido("Rivera Linarez");
        empleado.setId(0);
        empleado.setPuesto("Desarrollador");

        int actual = EmpleadoDAL.obtenerDatosFiltrados(empleado).size();
        Assertions.assertNotEquals(0, actual);
    }
}
