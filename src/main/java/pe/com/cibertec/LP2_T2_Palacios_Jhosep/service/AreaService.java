package pe.com.cibertec.LP2_T2_Palacios_Jhosep.service;
import java.util.List;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.model.AreaEntity;

public interface AreaService {
    List<AreaEntity> listarArea();
    AreaEntity buscarPorId(Integer id);
    AreaEntity crearArea(AreaEntity area);
    AreaEntity actualizarArea(AreaEntity area);
    void eliminarArea(Integer id);
}
