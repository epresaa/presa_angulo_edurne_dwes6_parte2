package birt.dwes.api.servicios;

import birt.dwes.api.Entity.Cliente;
import birt.dwes.api.dao.ClienteDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioClienteImpl implements ServicioCliente {
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Override
	public List<Cliente> findAll() {
		List<Cliente> lista = clienteDAO.findAll();
		return lista;
	}

	@Override
	public Cliente findById(int id) {
		Cliente cli = clienteDAO.findById(id);
		return cli;
	}

	@Override
	public void save(Cliente cli) {
		clienteDAO.save(cli);
	}

	@Override
	public void delete(int id) {
		clienteDAO.delete(id);
	}

}