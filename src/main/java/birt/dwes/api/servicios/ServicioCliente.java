package birt.dwes.api.servicios;

import java.util.List;
import birt.dwes.api.Entity.Cliente;

public interface ServicioCliente {
	public List<Cliente> findAll();
	
	public Cliente findById(int id);
	
	public void save(Cliente cli);
	
	public void delete(int id);
}