package birt.dwes.api.dao;

import java.util.List;
import birt.dwes.api.Entity.Cliente;

public interface ClienteDAO {
	public List<Cliente> findAll();
	
	public Cliente findById(int id);
	
	public void save(Cliente cli);
	
	public void delete(int id);
}
