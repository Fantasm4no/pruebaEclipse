package ec.edu.ups.ppw.empelectrica.dao;

import java.util.List;

import ec.edu.ups.ppw.empelectrica.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless 
public class ClienteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}
	
	public void delete(int id) throws Exception{
	    Cliente cliente = this.read(id);
	    if (cliente != null) {
	        em.remove(cliente);
	        System.out.println("Eliminado");
	    } else {
	        throw new Exception("No se puede eliminar el cliente. Cliente con id " + id + " no encontrado.");
	    }
	}

	
	public Cliente read(int id) throws Exception{
	    Cliente cliente = em.find(Cliente.class, id);
	    if (cliente == null) {
	        throw new Exception("Cliente con id " + id + " no encontrado.");
	    }
	    return cliente;
	}

	public List<Cliente> getAll(){
		String jpql = "SELECT c FROM Cliente c";
		Query query = em.createQuery(jpql, Cliente.class);
		return query.getResultList();
	}

}
