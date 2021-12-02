package entities;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Define que esta clase contiene todas las acciones a realizar en la BD
@Transactional  //Indica que todas las acciones en la BD se tomarán como transacciones

public class PacienteService {
	@Autowired  //Indica que lleve acabo todas las acciones con PacienteRepository
    private PacienteRepository repo;
	
     //Obetener todos los pacientes
    public List<Paciente> listAll() {
        return repo.findAll();
    }
     //Guardar en la BD
    public void save(Paciente paciente) {
        repo.save(paciente);
    }
     //Obetener paciente por ID
    public Paciente get(Integer id) {
        return repo.findById(id).get();
    }
     //Eliminar paciente por ID
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
