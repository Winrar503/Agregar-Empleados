package logicadenegocio;

import accesoadatos.EmpleadoDAL;
import entidadesdenegocio.Empleado;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoBL {
    public int guardar(Empleado empleado) throws SQLException {
        return EmpleadoDAL.guardar(empleado);
    }

    public int modificar(Empleado empleado) throws SQLException{
        return EmpleadoDAL.modificar(empleado);
    }

    public int eliminar(Empleado empleado) throws SQLException{
        return EmpleadoDAL.eliminar(empleado);
    }

    public ArrayList<Empleado> obtenerTodos() throws SQLException{
        return EmpleadoDAL.obtenerTodos();
    }

    public ArrayList<Empleado> obtenerDatosFiltrados(Empleado empleado) throws SQLException{
        return EmpleadoDAL.obtenerDatosFiltrados(empleado);
    }
}
