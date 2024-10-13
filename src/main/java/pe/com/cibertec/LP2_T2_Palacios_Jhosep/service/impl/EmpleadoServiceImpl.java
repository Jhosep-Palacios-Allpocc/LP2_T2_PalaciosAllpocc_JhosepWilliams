package pe.com.cibertec.LP2_T2_Palacios_Jhosep.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.model.EmpleadoEntity;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.repository.EmpleadoRepository;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.service.EmpleadoService;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	 	@Autowired
	    private EmpleadoRepository empleadoRepository;

	    @Override
	    public List<EmpleadoEntity> listarEmpleado() {
	        return empleadoRepository.findAll();
	    }

	    @Override
	    public EmpleadoEntity buscarPorId(String dni) {
	        return empleadoRepository.findById(dni).orElse(null);
	    }

	    @Override
	    public EmpleadoEntity crearEmpleado(EmpleadoEntity empleado) {
	        return empleadoRepository.save(empleado);
	    }

	    @Override
	    public EmpleadoEntity actualizarEmpleado(EmpleadoEntity empleado) {
	        return empleadoRepository.save(empleado);
	    }

	    @Override
	    public void eliminarEmpleado(String dni) {
	        empleadoRepository.deleteById(dni);
	    }
}
