package pe.com.cibertec.LP2_T2_Palacios_Jhosep.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.model.AreaEntity;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.service.AreaService; 
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.model.EmpleadoEntity;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private AreaService areaService; 

    //Lista empleados
    @GetMapping("/")
    public String listarEmpleados(Model model) {
        List<EmpleadoEntity> listaEmpleados = empleadoService.listarEmpleado();
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "listar_empleado"; 
    }

    //Detalle de empleado
    @GetMapping("/detalle/{id}")
    public String verDetalleEmpleado(Model model, @PathVariable("id") String id) {
        EmpleadoEntity empleadoEncontrado = empleadoService.buscarPorId(id);
        model.addAttribute("empleado", empleadoEncontrado);
        return "detalle_empleado"; 
    }


    @GetMapping("/registrar")
    public String mostrarRegistrarEmpleado(Model model) {
        model.addAttribute("empleado", new EmpleadoEntity());
        List<AreaEntity> listaAreas = areaService.listarArea(); 
        model.addAttribute("areas", listaAreas); 
        return "registrar_empleado"; 
    }

    @PostMapping("/registrar")
    public String registrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado) {
        empleadoService.crearEmpleado(empleado);
        return "redirect:/empleados/";
    }

    // Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable("id") String id) {
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados/"; 
    }

    // Editar
    @GetMapping("/editar/{id}")
    public String mostrarEditarEmpleado(@PathVariable("id") String id, Model model) {
        EmpleadoEntity empleadoEncontrado = empleadoService.buscarPorId(id);
        model.addAttribute("empleado", empleadoEncontrado);
        List<AreaEntity> listaAreas = areaService.listarArea(); 
        model.addAttribute("areas", listaAreas); 
        return "editar_empleado"; 
    }

    @PostMapping("/editar/{id}")
    public String editarEmpleado(@PathVariable("id") String id,
                                 @ModelAttribute("empleado") EmpleadoEntity empleado) {
        empleadoService.actualizarEmpleado(empleado);
        return "redirect:/empleados/"; 
    }
}