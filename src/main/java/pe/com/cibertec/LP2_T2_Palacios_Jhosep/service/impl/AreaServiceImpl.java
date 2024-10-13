package pe.com.cibertec.LP2_T2_Palacios_Jhosep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.model.AreaEntity;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.repository.AreaRepository;
import pe.com.cibertec.LP2_T2_Palacios_Jhosep.service.AreaService;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
    private AreaRepository areaRepository;

    @Override
    public List<AreaEntity> listarArea() {
        return areaRepository.findAll();
    }

    @Override
    public AreaEntity buscarPorId(Integer id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public AreaEntity crearArea(AreaEntity area) {
        return areaRepository.save(area);
    }

    @Override
    public AreaEntity actualizarArea(AreaEntity area) {
        return areaRepository.save(area);
    }

    @Override
    public void eliminarArea(Integer id) {
        areaRepository.deleteById(id);
    }
}
