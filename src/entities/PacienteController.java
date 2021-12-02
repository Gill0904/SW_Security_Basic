package entities;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Indicamos que esto es un servicio Web basado en Rest
public class PacienteController {
	@Autowired  //Se conecta automaticamente con PacienteService
    private PacienteService service;
	
	@GetMapping("/pacientes") //Obtiene informaci�n mediante una direcci�n
	//Obtiene tos los pacientes
	public List<Paciente> list() {
	    return service.listAll();
	}
	
	@GetMapping("/pacientes/{id}")//Obtiene informaci�n mediante una direcci�n
	//Obtiene una variable desde la direcci�n para obtener la informaci�n del paciente
	public ResponseEntity<Paciente> get(@PathVariable Integer id) { 
	    try {
	    	Paciente paciente = service.get(id);
	        return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Paciente>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/pacientes") //Ejecutamos el metodo Post mediente la ruta indicada
	//Ingresa un nuevo paciente enviando un RequestBody
	public void add(@RequestBody Paciente paciente) {
	    service.save(paciente);
	}
	
	@PutMapping("/pacientes/{id}") //Actualiza un estudiante mediante la ruta indicada
	//Se actualiza un paciente en la BD mandado los datos del paciente en un RequesteBody y su Id
	public ResponseEntity<?> update(@RequestBody Paciente paciente, @PathVariable Integer id) {
	    try {
	    	Paciente existPaciente = service.get(id);
	        service.save(paciente);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/pacientes/{id}") //Elimina un paciente mediante la ruta indicada
	//Se elimina un paciente de la BD mediante el id indicado en la direcci�n
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}
}
