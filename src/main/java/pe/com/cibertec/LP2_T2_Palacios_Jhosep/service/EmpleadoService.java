package pe.com.cibertec.LP2_T2_Palacios_Jhosep.service;

import java.util.List;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.model.EmpleadoEntity;

public interface EmpleadoService {
	List<EmpleadoEntity> listarEmpleado();
    EmpleadoEntity buscarPorId(String dni);
    EmpleadoEntity crearEmpleado(EmpleadoEntity empleado);
    EmpleadoEntity actualizarEmpleado(EmpleadoEntity empleado);
    void eliminarEmpleado(String dni);
}
