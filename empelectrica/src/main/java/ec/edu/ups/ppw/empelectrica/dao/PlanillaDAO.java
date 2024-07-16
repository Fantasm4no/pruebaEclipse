package ec.edu.ups.ppw.empelectrica.dao;

import java.util.List;
import ec.edu.ups.ppw.empelectrica.model.Planilla;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless 
public class PlanillaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Planilla planilla) {
		em.persist(planilla);
	}
	
	public void update(Planilla planilla) {
		em.merge(planilla);
	}
	
	public void delete(int id) throws Exception{
		Planilla planilla = this.read(id);
	    if (planilla != null) {
	        em.remove(planilla);
	        System.out.println("Eliminado");
	    } else {
	        throw new Exception("No se puede eliminar la planilla. Planilla con id " + id + " no encontrado.");
	    }
	}

	
	public Planilla read(int id) throws Exception{
		Planilla planilla = em.find(Planilla.class, id);
	    if (planilla == null) {
        throw new Exception("Planilla con id " + id + " no encontrado.");
	    }
	    return planilla;
	}

	public List<Planilla> getAll(){
		String jpql = "SELECT p FROM Planilla p";
		Query query = em.createQuery(jpql, Planilla.class);
		return query.getResultList();
	}

}
