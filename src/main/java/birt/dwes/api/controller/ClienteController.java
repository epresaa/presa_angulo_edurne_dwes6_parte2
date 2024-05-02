package birt.dwes.api.controller;

import org.springframework.web.bind.annotation.*;
import birt.dwes.api.Entity.Cliente;
import birt.dwes.api.servicios.ServicioCliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class ClienteController {
	@Autowired
	private ServicioCliente servicioCliente;
	
	// Métodos del CRUD
	// GET todos
	@GetMapping("/clientes")
	public List<Cliente> getClientes() {
        return servicioCliente.findAll();
    }
	
	// GET por id
	@GetMapping("/clientes/{id}")
	public Cliente mostrarId(@PathVariable int id) {
		// Determinar cliente
		Cliente cli = servicioCliente.findById(id);
		
		// Gestión de excepciones
		if(cli == null) {
			throw new RuntimeException("No existe ningún cliente con id: " + id);
		}
		// Si existe lo devuelve
		return cli;
	}
	
	// POST
	@PostMapping("/clientes")
	public Cliente crearCliente(@RequestBody Cliente cli) {
		cli.setId(0); 		// Temporal: id autoincremental
		servicioCliente.save(cli);
		return cli;
	}
	
	// PUT
	@PutMapping("/clientes/{id}")
	public ResponseEntity<String> modificarCliente(@RequestBody Cliente nuevo, @PathVariable int id) {
		// Determinar cliente
		Cliente cli = servicioCliente.findById(id);
				
		// Gestión de excepciones
		if(cli == null) {
			throw new RuntimeException("No existe ningún cliente con id: " + id);
		}
		
		// Actualización de datos
		cli.setNombre(nuevo.getNombre());
		cli.setApellidos(nuevo.getApellidos());
		cli.setEmail(nuevo.getEmail());
		cli.setDni(nuevo.getDni());
		cli.setRepre(nuevo.getRepre());
		
		// Guardado
		servicioCliente.save(cli);
		
		// Objeto ResponseEntity con mensaje de éxito
		return ResponseEntity.ok("Cliente con id " + id + " actualizado correctamente");
    }
	
	// DELETE
	@DeleteMapping("/clientes/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable int id) {
		// Determinar cliente
        Cliente cli = servicioCliente.findById(id);
        
        // Gestión de excepciones
        if (cli == null) {
            // Objeto ResponseEntity: representa toda la respuesta HTTP
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningún cliente con id: " + id);
        
        } else {
            // Borrado
            servicioCliente.delete(id);
            
            // Objeto ResponseEntity con mensaje de éxito
            return ResponseEntity.ok("Cliente con id " + id + " eliminado con éxito");
        }
    }
}
