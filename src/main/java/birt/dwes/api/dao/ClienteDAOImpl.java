package birt.dwes.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.query.*;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;

import birt.dwes.api.Entity.Cliente;


@Repository
public class ClienteDAOImpl implements ClienteDAO {
	@Autowired
	private EntityManager entityMan;
	
	@Override
	@Transactional
	public List<Cliente> findAll() {
		Session currentSession = entityMan.unwrap(Session.class);
		
		Query<Cliente> miQuery = currentSession.createQuery("from Cliente", Cliente.class);
		List<Cliente> clientes = miQuery.getResultList();
		
		return clientes;
	}

	@Override
	@Transactional
	public Cliente findById(int id) {
		Session currentSession = entityMan.unwrap(Session.class);
		Cliente cli = currentSession.get(Cliente.class, id);
		
		return cli;
	}

	@Override
	@Transactional
	public void save(Cliente cli) {
		Session currentSession = entityMan.unwrap(Session.class);
		currentSession.saveOrUpdate(cli);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session currentSession = entityMan.unwrap(Session.class);
		Query<Cliente> miQuery = currentSession.createQuery("delete from Cliente where id = ?1");
		miQuery.setParameter(1, id);
		miQuery.executeUpdate();		
	}

}
