import accesoadatos.EmpleadoDAL;
import entidadesdenegocio.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class EmpleadoDALTest {

    @Test
    public void guardarTest() throws SQLException{
        Empleado empleado = new Empleado();

        empleado.setNombre("Adrin adalberto");
        empleado.setApellido("Hernade Rivera");
        empleado.setEmail("adrn@gmail.com");
        empleado.setTelefono("8799-2343");
        empleado.setPuesto("Striper");

        int esperando = 1;
        int actual = EmpleadoDAL.guardar(empleado);
        Assertions.assertEquals(esperando, actual);
    }
}
